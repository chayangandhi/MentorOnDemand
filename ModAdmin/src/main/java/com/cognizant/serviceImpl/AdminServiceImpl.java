package com.cognizant.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.convertor.AdminConvertor;

import com.cognizant.entity.AdminEntity;
import com.cognizant.entity.MentorEntity;
import com.cognizant.entity.UserEntity;
import com.cognizant.interfac.AdminService;
import com.cognizant.model.AdminModel;
import com.cognizant.repo.AdminRepo;
import com.cognizant.repo.MentorRepo;
import com.cognizant.repo.UserRepo;
import com.netflix.discovery.converters.Auto;


@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepo adminDao;
	
	@Autowired
	private MentorRepo mentorRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	AdminConvertor adminConvertor = new AdminConvertor();
	

	@Override
	public boolean blockUser(int userId) {
	
		UserEntity userEntity=new UserEntity();
		userEntity.setUserStatus("Blocked");
		userEntity.setUserId(userId);
		 UserEntity save = userRepo.save(userEntity);
		 if(save==null)
			 return false;
		 return true;
	}

	@Override
	public boolean UnblockUser(int userId) {
		
		UserEntity userEntity=new UserEntity();
		userEntity.setUserStatus("Unblocked");
		userEntity.setUserId(userId);
		 UserEntity save = userRepo.save(userEntity);
		 if(save==null)
			 return false;
		 return true;
	}

	@Override
	public boolean blockMentor(int mentorId) {
	
		MentorEntity mentorEntity=new MentorEntity();
		mentorEntity.setMentorStatus("locked");
		mentorEntity.setMentorId(mentorId);
		 MentorEntity save = mentorRepo.save(mentorEntity);
		 if(save==null)
			 return false;
		 return true;
	}

	@Override
	public boolean UnblockMentor(int mentorId) {
		
		MentorEntity mentorEntity=new MentorEntity();
		mentorEntity.setMentorStatus("Unblocked");
		mentorEntity.setMentorId(mentorId);
		 MentorEntity save = mentorRepo.save(mentorEntity);
		 if(save==null)
			 return false;
		 return true;
	}

	//TODO To BE DONE LATER
	@Override
	public boolean getAdminLoginStatus(AdminModel adminModel) {
		AdminEntity adminEntity = adminConvertor.adminModelToEntity(adminModel);
		AdminEntity findById = adminDao.findById(adminEntity.getAdminId()).get();
		return true;
	}

	
}
