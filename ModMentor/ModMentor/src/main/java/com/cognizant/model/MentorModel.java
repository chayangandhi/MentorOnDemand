package com.cognizant.model;

public class MentorModel {

	private int mentorId;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private String contactNo;
	private String experience;
	private String technology;
	private String linkedUrl;
	
	private String timingSlot;
	
	private String mentorStatus;

	
	public String getTimingSlot() {
		return timingSlot;
	}

	public void setTimingSlot(String timingSlot) {
		this.timingSlot = timingSlot;
	}

	public int getMentorId() {
		return mentorId;
	}

	public void setMentorId(int mentorId) {
		this.mentorId = mentorId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getLinkedUrl() {
		return linkedUrl;
	}

	public void setLinkedUrl(String linkedUrl) {
		this.linkedUrl = linkedUrl;
	}
	public String getMentorStatus() {
		return mentorStatus;
	}

	public void setMentorStatus(String mentorStatus) {
		this.mentorStatus = mentorStatus;
	}

	
}
