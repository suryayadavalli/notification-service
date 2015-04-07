package com.hmis.core.notification.business.exception;

public class NotifcationException  extends RuntimeException{
	
	public static final String DEFAULT_MESSAGE = "Generic Exception";
	
	public NotifcationException() {
		super(DEFAULT_MESSAGE);
	}
	
	public NotifcationException(String message) {
		super(message);
	}
	
	public NotifcationException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

	public NotifcationException(String message, Throwable cause) {
		super(message, cause);
	}
	
	String errorCode;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	
	String errorGroup;

	public String getErrorGroup() {
		return errorGroup;
	}

	public void setErrorGroup(String errorGroup) {
		this.errorGroup = errorGroup;
	}
		
		

}
