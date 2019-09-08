package com.cognizant.model;


public class MentorSkillModel {
	
	private int mentorSkillId;
	public int getMentorSkillId() {
		return mentorSkillId;
	}
	public void setMentorSkillId(int mentorSkillId) {
		this.mentorSkillId = mentorSkillId;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public int getFees() {
		return fees;
	}
	public void setFees(int fees) {
		this.fees = fees;
	}
	private String skillName;
	private int fees;

}
