package com.alex.piper.model;

import java.sql.Date;

public class UserAction {
	private String action;
	private Date timestamp;
	private Date startTime;
	private Date endTime;
	private Mood mood;

	private enum Mood {
		HAPPY, SAD, NERVOUS, ANGRY, EXCITED, NEUTRAL, BAD, GOOD;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Mood getMood() {
		return mood;
	}

	public void setMood(Mood mood) {
		this.mood = mood;
	}

}
