package com.microservice.user.exception;

public class ResourceNotFoundException extends RuntimeException{

	public String resourcename;	
	public String fieldname;
    public  int fieldvalue;
	public ResourceNotFoundException(String resourcename, String fieldname, int fieldvalue) {
		super(String.format("%s Not found with %s : %s", resourcename,fieldname,fieldvalue ));
		this.resourcename = resourcename;
		this.fieldname = fieldname;
		this.fieldvalue = fieldvalue;
	}
	public String getResourcename() {
		return resourcename;
	}
	public void setResourcename(String resourcename) {
		this.resourcename = resourcename;
	}
	public String getFieldname() {
		return fieldname;
	}
	public void setFieldname(String fieldname) {
		this.fieldname = fieldname;
	}
	public int getFieldvalue() {
		return fieldvalue;
	}
	public void setFieldvalue(int fieldvalue) {
		this.fieldvalue = fieldvalue;
	}
	public ResourceNotFoundException() {
		super();
	}
    
    

}
