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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cognizant.interfac.UserService;
import com.cognizant.model.MentorModel;
import com.cognizant.model.UserModel;
import com.cognizant.validator.UserLoginValidator;


@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserLoginValidator loginValidator;

	@PostMapping("/login")
	public ResponseEntity<Void> doMentorLogin(@RequestBody UserModel userModel,Errors errors) {
		System.out.println(userModel.getEmail());
		ResponseEntity<Void> response = null;
		ValidationUtils.invokeValidator(loginValidator,userModel,errors);
		if(errors.hasErrors()){
			response=new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		else{                                                                                                                                               
			//HttpSession session=request.getSession(true);
			response=new ResponseEntity<Void>(HttpStatus.FOUND);
		}
		return response;
	}
	

	@PostMapping("/userRegister")
	public ResponseEntity<Void> register(@RequestBody UserModel userModel) {
		ResponseEntity<Void> response = null;

		userService.registerUser(userModel);
		response = new ResponseEntity<Void>(HttpStatus.CREATED);

		return response;

	}
	
	@GetMapping("mentorSearch/{technology}/{timingSlot}")
	public  ResponseEntity<List<MentorModel>> search(@PathVariable("technology")String technology , @PathVariable("timingSlot")String  timingSlot) {
                       
		ResponseEntity<List<MentorModel>> response = null;
		List<MentorModel> mentorList = userService.searchMentor(technology , timingSlot);
		response = new ResponseEntity<List<MentorModel>>(mentorList ,HttpStatus.OK);
		return response; 
		
		
	}

}
