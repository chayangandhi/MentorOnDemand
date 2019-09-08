package com.cognizant.convertor;

import com.cognizant.entity.MentorSkillEntity;

import com.cognizant.model.MentorSkillModel;

public class MentorSkillConvertor {
	
	MentorSkillModel mentorSkillModel = null;
	
	MentorSkillEntity mentorSkillEntity  = null;
	
	public MentorSkillModel mentorSkillEntityToModel(MentorSkillEntity mentorSkillEntity) {
		mentorSkillModel = new MentorSkillModel();
		mentorSkillModel.setMentorSkillId(mentorSkillEntity.getMentorSkillId());
		mentorSkillModel.setFees(mentorSkillEntity.getFees());
		mentorSkillModel.setSkillName(mentorSkillEntity.getSkillName());
		return mentorSkillModel;
		
	}
	
	public MentorSkillEntity mentorSkillModelToEntity(MentorSkillModel mentorSkillModel) {
		mentorSkillEntity = new MentorSkillEntity();
		mentorSkillEntity.setMentorSkillId(mentorSkillModel.getMentorSkillId());
		mentorSkillEntity.setFees(mentorSkillModel.getFees());
		mentorSkillEntity.setSkillName(mentorSkillModel.getSkillName());
		return mentorSkillEntity;
	}
	 
}
