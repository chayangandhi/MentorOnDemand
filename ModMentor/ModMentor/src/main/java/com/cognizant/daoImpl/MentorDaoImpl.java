package com.cognizant.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;


import com.cognizant.entity.MentorEntity;
import com.cognizant.entity.TrainingEntity;
import com.cognizant.interfac.MentorDao;


@Repository
public class MentorDaoImpl implements MentorDao {

	@PersistenceContext
	private EntityManager manager;
	
	

	@Transactional
	public boolean persistMentor(MentorEntity mentor) {
	String mentorStatus = "Unblock";
       mentor.setMentorStatus(mentorStatus);
		manager.persist(mentor);
		return true;
	}

	@Override
	public List<TrainingEntity> viewMentorList(int mentorId) {
		Query query= manager.createQuery("from TrainingEntity t where t.mentorId=:mentorId");
		query.setParameter("mentorId" , mentorId);
	    List<TrainingEntity> mentorHistoryList = query.getResultList();
		
		return mentorHistoryList;
	}

	@Override
	public boolean validateMentor(MentorEntity mentorEntity) {
		Query query=manager.createQuery("from MentorEntity m where m.email=:email And m.password=:password");
		query.setParameter("email",mentorEntity.getEmail());
		query.setParameter("password",mentorEntity.getPassword());
		List<MentorEntity> validMentor =query.getResultList();
		if(validMentor.isEmpty())
			return false;
		else
		return true;
	}

	@Transactional
	@Override
	public boolean updateMentor(MentorEntity mentorEntity) {
		manager.merge(mentorEntity);
		return true;
	}

	@Override
	public boolean mentorLogin(String email, String password) {
		Query query=manager.createQuery("from MentorEntity m where m.email=:email And m.password=:password");
		query.setParameter("email",email);
		query.setParameter("password",password);
		List<MentorEntity> validMentor =query.getResultList();
		if(validMentor.isEmpty())
			return false;
		else
		return true;
	}
}
