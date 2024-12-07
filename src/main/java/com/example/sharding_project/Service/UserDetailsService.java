package com.example.sharding_project.Service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sharding_project.Controller.UserDetailsController;
import com.example.sharding_project.Entity.UserDetails;
import com.example.sharding_project.Entity.UserDetailsDto;
import com.example.sharding_project.Repository.UserDetailsRepository;

@Service
public class UserDetailsService {
	private static final Logger logger = LoggerFactory.getLogger(UserDetailsService.class);
	@Autowired 
	private UserDetailsRepository userDetailsRepo;
	public UserDetailsDto addUser(UserDetailsDto userdetailsdto, Long userId) {
		try {
			UserDetails userDetails = this.DTOtoUserDetails(userdetailsdto,userId);
			UserDetails afterSaving = userDetailsRepo.save(userDetails);
			logger.info("user details saved successfully");
			return userDetailsToDto(afterSaving);
			
		}catch(Exception e) {
			logger.error("Could not create userdetails " + e);
		}
		return null;
	}

	private UserDetailsDto userDetailsToDto(UserDetails afterSaving) {
		try {
			UserDetailsDto userdetailsdto = new UserDetailsDto();
			userdetailsdto.setUserId(afterSaving.getUserId());
			userdetailsdto.setAge(afterSaving.getAge());
			userdetailsdto.setUserAddress(afterSaving.getUserAddress());
			userdetailsdto.setUserEmail(afterSaving.getUserEmail());
			userdetailsdto.setUserName(afterSaving.getUserName());
				return userdetailsdto;
			}catch(Exception e) {
				logger.error("Could not create userdetailsdto " + e);
			}
			return null;
	}

	private UserDetails DTOtoUserDetails(UserDetailsDto userdetailsdto, Long userId) {
		try {
		UserDetails userdetails = new UserDetails();
		userdetails.setUserId(userId);
		userdetails.setAge(userdetailsdto.getAge());
		userdetails.setUserAddress(userdetailsdto.getUserAddress());
		userdetails.setUserEmail(userdetailsdto.getUserEmail());
		userdetails.setUserName(userdetailsdto.getUserName());
			return userdetails;
		}catch(Exception e) {
			logger.error("Could not convert to userdetails  " + e);
		}
		return null;
	}
	
	
	
}
