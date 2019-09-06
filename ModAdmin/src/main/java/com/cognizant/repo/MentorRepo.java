package com.cognizant.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.entity.MentorEntity;

public interface MentorRepo extends JpaRepository<MentorEntity, Integer> {

}
