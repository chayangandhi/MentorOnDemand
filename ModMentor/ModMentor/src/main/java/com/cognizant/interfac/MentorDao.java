package com.cognizant.interfac;

import java.util.List;


import com.cognizant.entity.MentorEntity;
import com.cognizant.entity.TrainingEntity;
import com.cognizant.model.TrainingModel;

public interface MentorDao {
	boolean persistMentor(MentorEntity mentor);
	 List <TrainingEntity> viewMentorList(int mentorId);
	 boolean validateMentor(MentorEntity mentorEntity);
	 boolean updateMentor(MentorEntity mentorEntity);
	 
	 
	 boolean mentorLogin(String email,String password);
}
