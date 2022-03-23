package com.qa.bmtGym.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Accounts {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, length = 50) 
	private String accountName;
	
	@Column(nullable = false, length = 25) 
	private String accountPassword;
	
	@Column(nullable = false, length = 40) 
	private String email;
	
	@Column(nullable = false, length = 30) 
	private String telNumber;
	
	@Column(nullable = false, length = 40)
	private String address;
	
	@Column(nullable = false)
	private float price;
	
	@Column(nullable = false)
	private boolean isdelete;

	public Accounts(long id, String accountName, String accountPassword, String email, String telNumber, String address,
			float price, boolean isdelete) {
		super();
		this.id = id;
		this.accountName = accountName;
		this.accountPassword = accountPassword;
		this.email = email;
		this.telNumber = telNumber;
		this.address = address;
		this.price = price;
		this.isdelete = isdelete;
	}

	public Accounts(String accountName, String accountPassword, String email, String telNumber, String address,
			float price, boolean isdelete) {
		super();
		this.accountName = accountName;
		this.accountPassword = accountPassword;
		this.email = email;
		this.telNumber = telNumber;
		this.address = address;
		this.price = price;
		this.isdelete = isdelete;
	}

	public Accounts() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountPassword() {
		return accountPassword;
	}

	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public boolean isIsdelete() {
		return isdelete;
	}

	public void setIsdelete(boolean isdelete) {
		this.isdelete = isdelete;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountName == null) ? 0 : accountName.hashCode());
		result = prime * result + ((accountPassword == null) ? 0 : accountPassword.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (isdelete ? 1231 : 1237);
		result = prime * result + Float.floatToIntBits(price);
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
		if (accountName == null) {
			if (other.accountName != null)
				return false;
		} else if (!accountName.equals(other.accountName))
			return false;
		if (accountPassword == null) {
			if (other.accountPassword != null)
				return false;
		} else if (!accountPassword.equals(other.accountPassword))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (isdelete != other.isdelete)
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
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
		return "Accounts [id=" + id + ", accountName=" + accountName + ", accountPassword=" + accountPassword
				+ ", email=" + email + ", telNumber=" + telNumber + ", address=" + address + ", price=" + price
				+ ", isdelete=" + isdelete + "]";
	}
	


}
