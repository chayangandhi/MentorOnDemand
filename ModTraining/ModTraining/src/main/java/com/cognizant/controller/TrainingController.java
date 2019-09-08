package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.interfac.TrainingService;
import com.cognizant.model.TrainingModel;

@RestController
@RequestMapping("/training")
public class TrainingController {
	
	@Autowired 
	private TrainingService trainingService;
	
	
	@GetMapping("/userCompleted/{userId}")
	public ResponseEntity<List<TrainingModel>> getUserCompletedTraining(@PathVariable("userId") int userId ) {
		
		ResponseEntity<List<TrainingModel>> response = null;
		
		List<TrainingModel> userCompletedTrainingList = trainingService.getUserCompletedTrainingList(userId);
		response = new ResponseEntity<List<TrainingModel>>(userCompletedTrainingList , HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/mentorCompleted/{mentorId}")
	public ResponseEntity<List<TrainingModel>> getMentorCompletedTraining(@PathVariable("mentorId") int mentorId ) {
		
		ResponseEntity<List<TrainingModel>> response = null;
		
		List<TrainingModel> mentorCompletedTrainingList = trainingService.getMentorCompletedTrainingList(mentorId);
		response = new ResponseEntity<List<TrainingModel>>(mentorCompletedTrainingList , HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/userCurrent/{userId}")
	public ResponseEntity<List<TrainingModel>> getUserCurrentTraining(@PathVariable("userId") int userId ) {
		
		ResponseEntity<List<TrainingModel>> response = null;
		
		List<TrainingModel> userCurrentTrainingList = trainingService.getUserCurrentTrainingList(userId);
		response = new ResponseEntity<List<TrainingModel>>(userCurrentTrainingList , HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/mentorCurrent/{mentorId}")
	public ResponseEntity<List<TrainingModel>> getMentorCurrentTraining(@PathVariable("mentorId") int mentorId ) {
		
		ResponseEntity<List<TrainingModel>> response = null;
		
		List<TrainingModel> mentorCurrentTrainingList = trainingService.getMentorCurrentTrainingList(mentorId);
		response = new ResponseEntity<List<TrainingModel>>(mentorCurrentTrainingList , HttpStatus.OK);
		return response;
	}

}
