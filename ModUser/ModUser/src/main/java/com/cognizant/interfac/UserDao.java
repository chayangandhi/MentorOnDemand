package com.cognizant.interfac;

import java.util.List;

import com.cognizant.entity.MentorEntity;
import com.cognizant.entity.UserEntity;
import com.cognizant.model.UserModel;

public interface UserDao {

	boolean persistUser(UserEntity user);
   List <MentorEntity> getMentor(String technology , String timingSlot);
  boolean validateUser(UserEntity userEntity);
}
