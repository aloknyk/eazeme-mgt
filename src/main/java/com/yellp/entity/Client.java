package com.yellp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENT_DETAILS")
public class Client {
	@Id
	@Column(name = "EMAILID", nullable = false, updatable = false)
	private String emailId;
	@Column(name="USERNAME",nullable=false)
	private String userName;
	@Column(name="PASSWORD",nullable=false,unique=true)
	private String password;
	@Column(name="PHONENUMBER",nullable=false,unique=true)
	private String phoneNumber;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
