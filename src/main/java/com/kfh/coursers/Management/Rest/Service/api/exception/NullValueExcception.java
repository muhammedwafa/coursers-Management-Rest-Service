package com.kfh.coursers.Management.Rest.Service.api.exception;

public class NullValueExcception extends RuntimeException{
	String resourseName;
	String fieldName;
	long fieldValue;
	
	
	public NullValueExcception(String resourseName, String fieldName, long fieldValue) {
		super( String.format("%s Not found with %s : %s",resourseName, fieldName , fieldValue));
		this.resourseName = resourseName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

}
