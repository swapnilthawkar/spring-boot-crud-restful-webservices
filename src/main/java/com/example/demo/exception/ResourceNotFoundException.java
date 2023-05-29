package com.example.demo.exception;

public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String resourcename;
	private String fieldName;
	private Object fieldValue;
	public ResourceNotFoundException(String resourcename, String fieldName, Object fieldValue) {
		super(String.format("%s is not found with %s :'%s'",resourcename,fieldName,fieldValue));
		this.resourcename = resourcename;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	public String getResourcename() {
		return resourcename;
	}
	public void setResourcename(String resourcename) {
		this.resourcename = resourcename;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public Object getFieldValue() {
		return fieldValue;
	}
	public void setFieldValue(Object fieldValue) {
		this.fieldValue = fieldValue;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "ResourceNotFoundException [resourcename=" + resourcename + ", fieldName=" + fieldName + ", fieldValue="
				+ fieldValue + "]";
	}
	
	
	
	

}
