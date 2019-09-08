package com.cognizant.convertor;

import com.cognizant.entity.TrainingEntity;
import com.cognizant.model.TrainingModel;


public class TrainingConvertor {
 TrainingModel trainingModel = null;
 TrainingEntity trainingEntity = null;
	
 public TrainingEntity trainingModelToEntity(TrainingModel trainingModel) {
	 trainingEntity = new TrainingEntity();
	 trainingEntity.setTrainingId(trainingModel.getTrainingId());
	 trainingEntity.setUserId(trainingModel.getUserId());
	 trainingEntity.setCommission(trainingModel.getCommission());
	
	
	 trainingEntity.setMentorId(trainingModel.getMentorId());
	
	 trainingEntity.setStatus(trainingModel.getStatus());
	 trainingEntity.setRating(trainingModel.getRating());
	 
	 
	 return trainingEntity;
 }
 
 public TrainingModel trainingEntityToModel(TrainingEntity trainingEntity) {
	 trainingModel = new TrainingModel();
	 trainingModel.setTrainingId(trainingEntity.getTrainingId());
	 trainingModel.setUserId(trainingEntity.getUserId());
	 trainingModel.setCommission(trainingEntity.getCommission());
	
	
	 trainingModel.setMentorId(trainingEntity.getMentorId());
	
	 trainingModel.setStatus(trainingEntity.getStatus());
	 trainingModel.setRating(trainingEntity.getRating());
	 System.out.println(trainingModel);
	 return trainingModel;
 }
}
