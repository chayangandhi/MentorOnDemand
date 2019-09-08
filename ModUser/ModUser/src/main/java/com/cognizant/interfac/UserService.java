package com.cognizant.interfac;

import java.util.List;

import com.cognizant.entity.MentorEntity;
import com.cognizant.model.MentorModel;
import com.cognizant.model.UserModel;

public interface UserService {

	boolean registerUser(UserModel userModel);
	List<MentorModel> searchMentor(String technology , String timingSlot);
	boolean getUserLoginStatus(UserModel userModel);

}
