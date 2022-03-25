package com.qa.bmtGym;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.http.HttpEntity;

public class GymMemberShipDto {

	public long userId;
	public long accountId;
	public Date startDate;
	public int period;
	public LocalDate remaingTime;
	
	public GymMemberShipDto(long userId, long accountId, Date startDate, int period) {
		super();
		this.userId = userId;
		this.accountId = accountId;
		this.startDate = startDate;
		this.period = period;
		this.remaingTime = this.startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().plusDays(this.period);
		
	}
	
	
}
