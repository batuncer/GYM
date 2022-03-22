package com.qa.bmtGym.model;

public class Users {
	
	private int id;
	private String email;
	private String telNumber;
	private boolean delete;
	
	
	public Users(int id, String email, String telNumber, boolean delete) {
		super();
		this.id = id;
		this.email = email;
		this.telNumber = telNumber;
		this.delete = delete;
	}


	public Users(String email, String telNumber, boolean delete) {
		super();
		this.email = email;
		this.telNumber = telNumber;
		this.delete = delete;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public boolean isDelete() {
		return delete;
	}


	public void setDelete(boolean delete) {
		this.delete = delete;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (delete ? 1231 : 1237);
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((telNumber == null) ? 0 : telNumber.hashCode());
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
		if (delete != other.delete)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (telNumber == null) {
			if (other.telNumber != null)
				return false;
		} else if (!telNumber.equals(other.telNumber))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Users [id=" + id + ", email=" + email + ", telNumber=" + telNumber + ", delete=" + delete + "]";
	}
	
	
	

}
