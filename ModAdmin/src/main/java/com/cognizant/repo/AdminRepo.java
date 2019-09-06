package com.cognizant.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.entity.AdminEntity;

public interface AdminRepo extends JpaRepository<AdminEntity, Integer> {
	
	
	
}
