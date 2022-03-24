package com.qa.bmtGym.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GymMemberShip {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	

	@Column(nullable = false)
	private long userId;
	

	@Column(nullable = false)
	private long accountId ;
	
	@Column(nullable = false)
	private float price;
	
	@Column(nullable = false) 
	private membershipType mType;
	
	@Column(nullable = false)
	private Date startDate;
	
	@Column(nullable = false)
	private int periodDate;
	
	@Column(nullable = false)
	private Date createDate;
	
	@Column(nullable = false)
	private boolean isdelete;
	
	
	
	
	@Override
	public String toString() {
		return "GymMemberShip [userId=" + userId + ", accountId=" + accountId + ", price=" + price + ", mType=" + mType
				+ ", startDate=" + startDate + ", periodDate=" + periodDate + ", createDate=" + createDate + ", isdelete="
				+ isdelete + "]";
	}
	
	
	
	
	public GymMemberShip(long userId, long accountId, float price, membershipType mType, Date startDate, int periodDate,
			Date createDate, boolean isdelete) {
		super();
		this.userId = userId;
		this.accountId = accountId;
		this.price = price;
		this.mType = mType;
		this.startDate = startDate;
		this.periodDate = periodDate;
		this.createDate = createDate;
		this.isdelete = isdelete;
	}




	public GymMemberShip() {
		super();
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (accountId ^ (accountId >>> 32));;
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + (isdelete ? 1231 : 1237);
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((mType == null) ? 0 : mType.hashCode());
		result = prime * result + periodDate;
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + (int) (userId ^ (userId >>> 32));;;
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
		GymMemberShip other = (GymMemberShip) obj;
		if (accountId != other.accountId)
			return false;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (isdelete != other.isdelete)
			return false;
		if (id != other.id)
			return false;
		if (mType != other.mType)
			return false;
		if (periodDate != other.periodDate)
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	public GymMemberShip(long id, long userId, long accountId, float price, membershipType mType, Date startDate,
			int periodDate, Date createDate, boolean isdelete) {
		super();
		this.id = id;
		this.userId = userId;
		this.accountId = accountId;
		this.price = price;
		this.mType = mType;
		this.startDate = startDate;
		this.periodDate = periodDate;
		this.createDate = createDate;
		this.isdelete = isdelete;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getaccountId() {
		return accountId;
	}
	public void setaccountId(long accountId) {
		this.accountId = accountId;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public membershipType getmType() {
		return mType;
	}
	public void setmType(membershipType mType) {
		this.mType = mType;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public int getPeriodDate() {
		return periodDate;
	}
	public void setPeriodDate(int periodDate) {
		this.periodDate = periodDate;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public boolean isisdelete() {
		return isdelete;
	}
	public void setisdelete(boolean isdelete) {
		this.isdelete = isdelete;
	}
	 
	public enum membershipType {
		none, standart, premium, gold,

	}
}


