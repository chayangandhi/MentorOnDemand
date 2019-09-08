package com.cognizant.daoImpl;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cognizant.entity.MentorEntity;
import com.cognizant.entity.UserEntity;
import com.cognizant.interfac.UserDao;
import com.cognizant.model.UserModel;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager manager;

	@Transactional
	public boolean persistUser(UserEntity user) {
		String userStatus = "Unblock";
        user.setUserStatus(userStatus);
		manager.persist(user);
		return true;
	}

	@Override
	@Transactional
	public List<MentorEntity> getMentor(String technology, String timingSlot) {
		Query query= manager.createQuery("from MentorEntity m where m.technology=:technology And m.timingSlot=:timingSlot");
		query.setParameter("technology" , technology);
		query.setParameter("timingSlot" , timingSlot);
		
	    List<MentorEntity> mentorList = query.getResultList();
		return mentorList;
	}

	@Override
	public boolean validateUser(UserEntity userEntity) {
		Query query=manager.createQuery("from UserEntity u where u.email=:email And u.password=:password");
		query.setParameter("email",userEntity.getEmail());
		query.setParameter("password",userEntity.getPassword());
		List<UserEntity> validUser = query.getResultList();
		if(validUser.isEmpty())
			return false;
		else
		return true;
	}

}
