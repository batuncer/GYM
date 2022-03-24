package com.qa.bmtGym.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@Column(nullable = false)
	private String fullName;
	
	@Column(nullable = false)
	private int height;
	
	@Column(nullable = false)
	private int weight;
	
	@Column(nullable = false, length = 40) 
	private String email;
	
	@Column(nullable = false, length = 30) 
	private String telNumber;
	
	@Column(nullable = false)
	private boolean isdelete;
	
	
	
	
	public Users() {
		super();
	}




	public Users(long id, String fullName, int height, int weight, String email, String telNumber, boolean isdelete) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.height = height;
		this.weight = weight;
		this.email = email;
		this.telNumber = telNumber;
		this.isdelete = isdelete;
	}




	public Users(String fullName, int height, int weight, String email, String telNumber, boolean isdelete) {
		super();
		this.fullName = fullName;
		this.height = height;
		this.weight = weight;
		this.email = email;
		this.telNumber = telNumber;
		this.isdelete = isdelete;
	}




	public long getId() {
		return id;
	}




	public void setId(long id) {
		this.id = id;
	}




	public String getFullName() {
		return fullName;
	}




	public void setFullName(String fullName) {
		this.fullName = fullName;
	}




	public int getHeight() {
		return height;
	}




	public void setHeight(int height) {
		this.height = height;
	}




	public int getWeight() {
		return weight;
	}




	public void setWeight(int weight) {
		this.weight = weight;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getTelNumber() {
		return telNumber;
	}




	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}




	public boolean isdelete() {
		return isdelete;
	}




	public void setDelete(boolean isdelete) {
		this.isdelete = isdelete;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + height;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (isdelete ? 1231 : 1237);
		result = prime * result + ((telNumber == null) ? 0 : telNumber.hashCode());
		result = prime * result + weight;
		return result;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		if (height != other.height)
			return false;
		if (id != other.id)
			return false;
		if (isdelete != other.isdelete)
			return false;
		if (telNumber == null) {
			if (other.telNumber != null)
				return false;
		} else if (!telNumber.equals(other.telNumber))
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}




	@Override
	public String toString() {
		return "Users [id=" + id + ", fullName=" + fullName + ", height=" + height + ", weight=" + weight + ", email="
				+ email + ", telNumber=" + telNumber + ", isdelete=" + isdelete + "]";
	}





}
