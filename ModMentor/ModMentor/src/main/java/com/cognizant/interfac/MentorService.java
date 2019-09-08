package com.cognizant.interfac;

import java.util.List;

import com.cognizant.entity.TrainingEntity;

import com.cognizant.model.MentorModel;
import com.cognizant.model.TrainingModel;

public interface MentorService {

	boolean registerMentor(MentorModel mentorModel);
	List<TrainingModel> viewMentorList(int mentorId);
	boolean getMentorLoginStatus(MentorModel mentorModel);
	boolean updateMentor(MentorModel mentorModel);
	
	boolean mentorLogin(String email,String password);

}