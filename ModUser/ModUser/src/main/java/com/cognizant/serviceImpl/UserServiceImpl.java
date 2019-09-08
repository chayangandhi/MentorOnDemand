package com.cognizant.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.convertor.MentorConvertor;
import com.cognizant.convertor.UserConvertor;

import com.cognizant.entity.MentorEntity;
import com.cognizant.entity.UserEntity;
import com.cognizant.interfac.UserDao;
import com.cognizant.interfac.UserService;

import com.cognizant.model.MentorModel;
import com.cognizant.model.UserModel;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	UserConvertor userConvertor = new UserConvertor();
	MentorConvertor mentorConvertor = new MentorConvertor();

	@Override
	public boolean registerUser(UserModel userModel) {
		UserEntity user = userConvertor.userModelToEntity(userModel);
		return userDao.persistUser(user);
	}

	@Override
	public List<MentorModel> searchMentor(String technology, String timingSlot) {
		List<MentorEntity> mentorList = userDao.getMentor(technology,timingSlot);
		
		List<MentorModel> mentorModelList = new ArrayList<MentorModel>();
        MentorModel mentorModel = null;
		
		for(int i=0; i<mentorList.size(); i++)
		{
			MentorEntity mentorEntity = mentorList.get(i);
     	    mentorModel = mentorConvertor.mentorEntityToModel(mentorEntity);
			mentorModelList.add(mentorModel);
		}
		
		
		return mentorModelList;
		
	}

	@Override
	public boolean getUserLoginStatus(UserModel userModel) {
		UserEntity userEntity = userConvertor.userModelToEntity(userModel);
		return userDao.validateUser(userEntity);
	}

}
