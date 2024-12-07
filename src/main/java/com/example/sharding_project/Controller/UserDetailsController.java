package com.example.sharding_project.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sharding_project.DbConfig.DataSourceContextHolder;
import com.example.sharding_project.DbConfig.DataSourceEnum;
import com.example.sharding_project.Entity.UserDetailsDto;
import com.example.sharding_project.Service.UserDetailsService;


@RestController
@RequestMapping("/userDetails")
public class UserDetailsController {
	private static final Logger logger = LoggerFactory.getLogger(UserDetailsController.class);
	Long totalservers = (long) DataSourceEnum.values().length;
	@Autowired
	private UserDetailsService userdetailservice;
	
	@PostMapping("/add/{userId}/")
	public ResponseEntity<?> addUsers(@PathVariable Long userId, @RequestBody UserDetailsDto userdetailsdto){
		// Implementation of sharding on two databases.. logic used - key based sharding
		// datasourceToselect = id%totalservers
		/*{
		  "userName":"Bikramjit",
		  "userAddress":"Asansol",
		  "age":"25",
		  "userEmail":"test@gmail.com"
		}*/
		try {
		int dataSourcekey = (int) (userId%totalservers);
		DataSourceContextHolder.set(DataSourceEnum.values()[dataSourcekey]);
		logger.info("Current dataSource " + DataSourceContextHolder.getDatabase() + " dataSource key " + dataSourcekey);
		UserDetailsDto detailsDto = userdetailservice.addUser(userdetailsdto,userId);
		return new ResponseEntity<UserDetailsDto>(detailsDto,HttpStatus.CREATED);
		}catch(Exception e) {
			logger.error("error while adding userdetails " + e);
		}
		return new ResponseEntity<UserDetailsDto>(HttpStatus.SERVICE_UNAVAILABLE);
	}

}
