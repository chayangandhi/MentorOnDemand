package com.cognizant.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.cognizant.entity.TrainingEntity;
import com.cognizant.interfac.TrainingDao;
import com.cognizant.model.TrainingModel;

@Repository
public class TrainingDaoImpl implements TrainingDao{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<TrainingEntity> getUserCompletedTrainingList(int userId) {
		Query query= manager.createQuery("from TrainingEntity t where t.userId=:userId and t.status=:status");
		query.setParameter("userId" , userId);
		query.setParameter("status" , "completed");
		
		
	    List<TrainingEntity> userCompletedTrainingList = query.getResultList();
		return userCompletedTrainingList;
		
	}

	@Override
	public List<TrainingEntity> getMentorCompletedTrainingList(int mentorId) {
		Query query= manager.createQuery("from TrainingEntity t where t.mentorId=:mentorId and t.status=:status");
		query.setParameter("mentorId" , mentorId);
		query.setParameter("status" , "completed");
		
		
	    List<TrainingEntity> userCompletedTrainingList = query.getResultList();
		return userCompletedTrainingList;
	}

	@Override
	public List<TrainingEntity> getUserCurrentTrainingList(int userId) {
		Query query= manager.createQuery("from TrainingEntity t where t.userId=:userId and t.status=:status");
		query.setParameter("userId" , userId);
		query.setParameter("status" , "current");
		
		
	    List<TrainingEntity> userCurrentTrainingList = query.getResultList();
		return userCurrentTrainingList;
	}

	@Override
	public List<TrainingEntity> getMentorCurrentTrainingList(int mentorId) {
		Query query= manager.createQuery("from TrainingEntity t where t.mentorId=:mentorId and t.status=:status");
		query.setParameter("mentorId" , mentorId);
		query.setParameter("status" , "current");
		
		
	    List<TrainingEntity> userCurrentTrainingList = query.getResultList();
		return userCurrentTrainingList;
	}

}
