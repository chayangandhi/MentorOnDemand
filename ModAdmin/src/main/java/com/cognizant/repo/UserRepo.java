package com.cognizant.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.entity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Integer> {
	
}
