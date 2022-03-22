package com.qa.bmtGym.model;

public class Accounts {
	
	private int id;
	private String name;
	private String password;
	private String email;
	private String telNumber;
	private boolean delete;
	
	
	
	public Accounts(int id, String name, String password, String email, String telNumber, boolean delete) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.telNumber = telNumber;
		this.delete = delete;
	}
	
	
	public Accounts(String name, String password, String email, String telNumber, boolean delete) {
		super();
		this.name = name;
		this.password = password;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		Accounts other = (Accounts) obj;
		if (delete != other.delete)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
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
		return "Accounts [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", telNumber="
				+ telNumber + ", delete=" + delete + "]";
	}
	
	

}
