package com.hmis.core.notification.model;

import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.hmis.core.notification.common.Constants.NotificationStatus;

@XmlType(name = "Notification")
@XmlRootElement(name = "notification")
@XmlAccessorType(XmlAccessType.FIELD)
public class Notification {

	@XmlElement(name = "notificationId")
	private String externalId;
	
	@XmlElement(name="type")
	private String type;
	
	@XmlElement(name = "notificationData")
	private Map<String,String> notificationData;
	
	@XmlElement(name = "status")
	private NotificationStatus status;

	@XmlElement(name = "statusMessage")
	private String statusMessage;
	
	@XmlElement(name = "method")
	private String method;
	
	@XmlElementWrapper(name="recipients")
	private List<String> recipients;
	
	public void setExternalId(String externalId)	{
		this.externalId = externalId;
	}
	public String getExternalId() {
		return externalId;
	}

	public Map<String,String> getNotificationData() {
		return notificationData;
	}
	public void setNotificationData(Map<String,String> notificationData) {
		this.notificationData = notificationData;
	}
	
	public NotificationStatus getStatus() {
		return status;
	}
	public void setStatus(NotificationStatus status) {
		this.status = status;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<String> getRecipients() {
		return recipients;
	}
	public void setRecipients(List<String> recipients) {
		this.recipients = recipients;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	
	

}