package com.cognizant.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cognizant.convertor.MentorConvertor;
import com.cognizant.convertor.TrainingConvertor;

import com.cognizant.entity.MentorEntity;
import com.cognizant.entity.TrainingEntity;
import com.cognizant.interfac.MentorDao;
import com.cognizant.interfac.MentorService;
import com.cognizant.model.MentorModel;
import com.cognizant.model.TrainingModel;

@Service
public class MentorServiceImpl implements MentorService {

	@Autowired
	private MentorDao mentorDao;
	
	MentorConvertor mentorConvertor = new MentorConvertor();
	TrainingConvertor trainingConvertor = new TrainingConvertor();

	@Override
	public boolean registerMentor(MentorModel mentorModel) {
		MentorEntity mentor = mentorConvertor.mentorModelToEntity(mentorModel);
		return mentorDao.persistMentor(mentor);
	}

	@Override
	public List<TrainingModel> viewMentorList(int mentorId) {
		TrainingModel trainingModel = null;
		List<TrainingModel> mentorModelHistoryList = new ArrayList<TrainingModel>();
		List<TrainingEntity> mentorEntityHistoryList = mentorDao.viewMentorList(mentorId);
		for(int i=0; i< mentorEntityHistoryList.size(); i++)
		{
			TrainingEntity trainingEntity = mentorEntityHistoryList.get(i);
			trainingModel = trainingConvertor.trainingEntityToModel(trainingEntity);
			mentorModelHistoryList.add(trainingModel);
		}
		
		return mentorModelHistoryList;
	}

	@Override
	public boolean getMentorLoginStatus(MentorModel mentorModel) {
		MentorEntity mentorEntity = mentorConvertor.mentorModelToEntity(mentorModel);
		return mentorDao.validateMentor(mentorEntity);
	}

	@Override
	public boolean updateMentor(MentorModel mentorModel) {
		MentorEntity mentorEntity = mentorConvertor.mentorModelToEntity(mentorModel);
		return mentorDao.updateMentor(mentorEntity);
		
	}

	@Override
	public boolean mentorLogin(String email, String password) {
	
		return mentorDao.mentorLogin(email , password);
	}

	

}
