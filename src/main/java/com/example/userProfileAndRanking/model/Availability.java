package com.example.userProfileAndRanking.model;

import org.springframework.stereotype.Component;

@Component
public class Availability {

	private long userId;

	private String beginHour;
	private String endHour;
	private String comment;

	public Availability() {
		super();
	}

	public Availability(long userId, String beginHour, String endHour) {
		super();
		this.userId = userId;
		this.beginHour = beginHour;
		this.endHour = endHour;
	}

	public long getId() {
		return userId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getBeginHour() {
		return beginHour;
	}

	public void setBeginHour(String beginHour) {
		this.beginHour = beginHour;
	}

	public String getEndHour() {
		return endHour;
	}

	public void setEndHour(String endHour) {
		this.endHour = endHour;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Availability [userId=" + userId + ", beginHour=" + beginHour + ", endHour=" + endHour + ", comment="
				+ comment + "]";
	}

}
