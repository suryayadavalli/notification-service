package com.hmis.core.notification.model;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.hmis.core.notification.common.Constants.NotificationStatus;

@XmlType(name = "NotificationHeader")
@XmlRootElement(name = "notificationHeader")
@XmlAccessorType(XmlAccessType.FIELD)
public class NotificationLine extends ClientModel {

	@XmlElement(name = "notificationHeaderId")
	private String externalId;
	
	@XmlElement(name = "originator")
	private Originator originator;
	
	@XmlElement(name = "status")
	private NotificationStatus status;

	@XmlElement(name = "statusMessage")
	private String statusMessage;
	
		
	@XmlElementWrapper(name="recipients")
	@XmlElements(@XmlElement(name="recipient", type=Recipient.class))
	private List<Recipient> recipients;
	
	public void setExternalId(String externalId)	{
		this.externalId = externalId;
	}
	public String getExternalId() {
		return externalId;
	}
	public Originator getOriginator() {
		return originator;
	}
	public void setOriginator(Originator originator) {
		this.originator = originator;
	}

	public List<Recipient> getRecipients() {
		return recipients;
	}
	public void setRecipients(List<Recipient> recipients) {
		this.recipients = recipients;
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

}