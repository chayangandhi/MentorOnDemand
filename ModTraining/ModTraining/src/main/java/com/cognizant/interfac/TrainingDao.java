package com.cognizant.interfac;

import java.util.List;

import com.cognizant.entity.TrainingEntity;
import com.cognizant.model.TrainingModel;

public interface TrainingDao {
	
		List<TrainingEntity> getUserCompletedTrainingList(int userId);
		List<TrainingEntity> getMentorCompletedTrainingList(int mentorId);
		List<TrainingEntity> getUserCurrentTrainingList(int userId);
		List<TrainingEntity>  getMentorCurrentTrainingList(int mentorId);
}
