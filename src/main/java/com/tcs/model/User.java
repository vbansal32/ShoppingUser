package com.tcs.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="USER")
@DynamicUpdate
public class User {
	@Id
	@Column(name="userid")
	private int userId;
	@Column(name="username")
	private String userName;
	@Column(name="dob")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dob;
	@Column(name="address")
	private String address;
	
	public User() {
		super();
	}
	
	public User(int userId, String userName, Date dob, String address) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.dob = dob;
		this.address = address;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", dob=" + dob + ", address=" + address
				+ "]";
	}
	

}
