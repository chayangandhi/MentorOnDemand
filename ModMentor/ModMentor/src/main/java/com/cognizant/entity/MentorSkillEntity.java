package com.cognizant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Mentor_Skills_table")
public class MentorSkillEntity {
	
	@Id
	@Column(name = "Mentor_Skill_id")
	private int mentorSkillId;
	

	@Column(name = "Skill_Name")
	private String skillName;
	
	@Column(name = "Fees")
	private int fees;
	
	
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

	
	
	

}
