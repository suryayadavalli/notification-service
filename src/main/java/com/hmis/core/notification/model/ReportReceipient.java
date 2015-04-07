package com.hmis.core.notification.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Resource")
@XmlRootElement(name = "resource")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReportReceipient extends ClientModel{
	
	@XmlElement(name = "resourceId")
	String resourceId;
	

	@XmlElement(name = "firstName")
	private String firstName;
	
	@XmlElement(name = "lastName")
	private String lastName;
	
	@XmlElement(name = "middleName")
	private String middleName;
	
	@XmlElement(name = "middleName")
	private String email;

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
