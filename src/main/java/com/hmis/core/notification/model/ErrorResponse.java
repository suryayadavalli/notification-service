package com.hmis.core.notification.model;

import javax.xml.bind.annotation.XmlAccessType;import javax.xml.bind.annotation.XmlAccessorType;import javax.xml.bind.annotation.XmlElement;import javax.xml.bind.annotation.XmlRootElement;import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Error")
@XmlRootElement(name = "error")
@XmlAccessorType(XmlAccessType.FIELD)
public class ErrorResponse extends ClientModel {

	@XmlElement(name = "code")
	private String code;

	@XmlElement(name = "message")
	private String message;

	

	public ErrorResponse() {
	}

	public ErrorResponse(String code, String message) {
		setCode(code);
		setMessage(message);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
