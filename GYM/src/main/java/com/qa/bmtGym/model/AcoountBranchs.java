package com.qa.bmtGym.model;

import java.util.Date;

public class AcoountBranchs {
	
	private int id;
	private int userId;
	private int acountId;
	private float price;
	private Date startDate;
	private Date createDate;
	private int periodTime;
	private boolean delete;
	
	
	public AcoountBranchs(int id, int userId, int acountId, float price, Date startDate, Date createDate,
			int periodTime, boolean delete) {
		super();
		this.id = id;
		this.userId = userId;
		this.acountId = acountId;
		this.price = price;
		this.startDate = startDate;
		this.createDate = createDate;
		this.periodTime = periodTime;
		this.delete = delete;
	}


	public AcoountBranchs(int userId, int acountId, float price, Date startDate, Date createDate, int periodTime,
			boolean delete) {
		super();
		this.userId = userId;
		this.acountId = acountId;
		this.price = price;
		this.startDate = startDate;
		this.createDate = createDate;
		this.periodTime = periodTime;
		this.delete = delete;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getAcountId() {
		return acountId;
	}


	public void setAcountId(int acountId) {
		this.acountId = acountId;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public int getPeriodTime() {
		return periodTime;
	}


	public void setPeriodTime(int periodTime) {
		this.periodTime = periodTime;
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
		result = prime * result + acountId;
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + (delete ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + periodTime;
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + userId;
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
		AcoountBranchs other = (AcoountBranchs) obj;
		if (acountId != other.acountId)
			return false;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (delete != other.delete)
			return false;
		if (id != other.id)
			return false;
		if (periodTime != other.periodTime)
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


	@Override
	public String toString() {
		return "AcoountBranchs [id=" + id + ", userId=" + userId + ", acountId=" + acountId + ", price=" + price
				+ ", startDate=" + startDate + ", createDate=" + createDate + ", periodTime=" + periodTime + ", delete="
				+ delete + "]";
	}
	
	
	

}
