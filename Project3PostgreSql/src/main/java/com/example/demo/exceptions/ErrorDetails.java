package com.example.demo.exceptions;

import java.util.Date;

public class ErrorDetails {
	
	
	private Date timestap;
	private String massage;
	private String details;
	
	public Date getTimestap() {
		return timestap;
	}
	public void setTimestap(Date timestap) {
		this.timestap = timestap;
	}
	public String getMassage() {
		return massage;
	}
	public void setMassage(String massage) {
		this.massage = massage;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public ErrorDetails(Date timestap, String massage, String details) {
		super();
		this.timestap = timestap;
		this.massage = massage;
		this.details = details;
	}
	public ErrorDetails() {
		super();
	}
	
	

}
