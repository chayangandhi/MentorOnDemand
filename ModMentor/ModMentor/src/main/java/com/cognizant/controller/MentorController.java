package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.interfac.MentorService;

import com.cognizant.model.MentorModel;
import com.cognizant.model.TrainingModel;
import com.cognizant.validator.MentorLoginValidator;


@RestController
@RequestMapping("/mentor")
public class MentorController {

	@Autowired
	private MentorService mentorService;
	

	@Autowired
	private MentorLoginValidator loginValidator;

	@GetMapping("/adminRegister")
	public String register() {
		return "hello";

	}
	
	
	@PostMapping("/mentorLoginCheck")
	public boolean doMentorLogin(@RequestBody MentorModel mentorModel,Errors errors) {
	//	ResponseEntity<Boolean> response = null;
		ValidationUtils.invokeValidator(loginValidator,mentorModel,errors);
		if(errors.hasErrors()){
			return false;
			//response=new ResponseEntity<Boolean>(false , HttpStatus.NOT_FOUND);
		}
		else{        
			return true;
			//HttpSession session=request.getSession(true);
			//response=new ResponseEntity<Boolean>(true , HttpStatus.FOUND);
		}
		// return response;
	}
	
	
	@PostMapping("/mentorRegister")
	public ResponseEntity<Void> register(@RequestBody MentorModel mentorModel) {
		ResponseEntity<Void> response = null;

		mentorService.registerMentor(mentorModel);
		response = new ResponseEntity<Void>(HttpStatus.CREATED);

		return response;

	}
	
	@GetMapping("/viewHistory/{mentorId}")
	public ResponseEntity<List<TrainingModel>> viewMentorHistory(@PathVariable("mentorId") int mentorId ) {
		
		ResponseEntity<List<TrainingModel>> response = null;
		
		List<TrainingModel> mentorModelSHistoryList = mentorService.viewMentorList(mentorId);
		response = new ResponseEntity<List<TrainingModel>>(mentorModelSHistoryList , HttpStatus.OK);
		return response;
	}
	
	@PostMapping("/updateMentor")
	public  ResponseEntity<Void> editMentor(@RequestBody MentorModel mentorModel) {
		ResponseEntity<Void> response = null;
		boolean updateSkill = mentorService.updateMentor(mentorModel);
		if(updateSkill == true)
			response=new ResponseEntity<Void>(HttpStatus.ACCEPTED);	
		else
			response=new ResponseEntity<Void>(HttpStatus.NOT_MODIFIED);
		return response;
	}
	
	@GetMapping("/mentorLoginChec/{email}/{password}")
	public ResponseEntity<Boolean> doMentor(@PathVariable("email") String email,@PathVariable("password") String password) {
		ResponseEntity<Boolean> response = null;
	
		boolean loginStatus = mentorService.mentorLogin(email, password);
		if(loginStatus==true){

			response=new ResponseEntity<Boolean>(true , HttpStatus.FOUND);
		}
		else{        
			response=new ResponseEntity<Boolean>(false , HttpStatus.NOT_FOUND);
		}
		 return response;
	}
	

}
