package com.cognizant.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Trainings_Table")
public class TrainingEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int trainingId;

	@NotNull
	@Column(name = "User_Id")
	private int userId;

	@NotNull
	@Column(name = "MentorId")
	private int mentorId;

	

	@NotNull
	@Column(name = "Rating")
	private int rating;

	@NotNull
	@Column(name = "Status")
	private String status;

	@NotNull
	@Column(name = "Commission")
	private double commission;

	
	public int getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getMentorId() {
		return mentorId;
	}

	public void setMentorId(int mentorId) {
		this.mentorId = mentorId;
	}



	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getCommission() {
		return commission;
	}

	public void setCommission(double commission) {
		this.commission = commission;
	}



	@Override
	public String toString() {
		return "Training [trainingId=" + trainingId + ", userId=" + userId + ", mentorId=" + mentorId + 
				 ", rating=" + rating + ", status=" + status + ", commission=" + commission+ "]";
	}

}
