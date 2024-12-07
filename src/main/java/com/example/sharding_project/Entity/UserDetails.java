package com.example.sharding_project.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user_details")
public class UserDetails {
	public UserDetails() {
	}

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long userId;
	@Column(name="user_name")
	private String userName;
	@Column(name="user_address")
	private String userAddress;
	
	private int age;
	@Column(name="user_email")
	private String userEmail;
	
	
	public UserDetails(Long userId, String userName, String userAddress, int age, String userEmail) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userAddress = userAddress;
		this.age = age;
		this.userEmail = userEmail;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	

}
