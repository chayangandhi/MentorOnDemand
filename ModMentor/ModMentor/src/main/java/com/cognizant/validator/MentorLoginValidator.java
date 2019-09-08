package com.cognizant.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.cognizant.interfac.MentorService;
import com.cognizant.model.MentorModel;


@Component("LoginValidator")
public class MentorLoginValidator implements Validator {

	@Autowired
	private MentorService mentorService;
		
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return arg0.equals(MentorModel.class);
		
	}

	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
		MentorModel mentorModel=(MentorModel)arg0;
		boolean loginResult=mentorService.getMentorLoginStatus(mentorModel);
		if(loginResult==false)
		{
			arg1.rejectValue("email","com.cognizant.controller.wrongUserName");
			arg1.rejectValue("password","com.cognizant.controller.wrongPassword");			
		}
	}

}
