package com.application.blog.exceptions;

public class ResourceNotFoundException  extends RuntimeException{
	String resourseName;
	String field;
	long fielValue;

	public ResourceNotFoundException(String resourseName, String field, long fielValue) {
		super(String.format("%s not found with %s : %s", resourseName,field,fielValue));
		this.resourseName = resourseName;
		this.field = field;
		this.fielValue = fielValue;
	}


	public ResourceNotFoundException() {
		super();
	}


	public String getResourseName() {
		return resourseName;
	}

	public void setResourseName(String resourseName) {
		this.resourseName = resourseName;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public long getFielValue() {
		return fielValue;
	}

	public void setFielValue(long fielValue) {
		this.fielValue = fielValue;
	}




}
