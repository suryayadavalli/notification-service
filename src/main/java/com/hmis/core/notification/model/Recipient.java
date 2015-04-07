package com.hmis.core.notification.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.hmis.core.notification.common.Constants.NotificationMethod;
import com.hmis.core.notification.common.Constants.NotificationStatus;

@XmlType(name = "Recipient")
@XmlAccessorType(XmlAccessType.FIELD)
public class Recipient {

	@XmlElement(name="id")
	private String externalId;

	@XmlElement(name="username")
	private String username;
	
	@XmlElement(name = "notificationId")
	private String notificationId;

	@XmlElement(name="deliveryMethod")
	private NotificationMethod deliveryMethod;
	
	@XmlElement(name="deliverTo")
	private String deliverTo;
	
	@XmlElement(name = "carrierAttempts")
	private Integer carrierAttempts;

	@XmlElement(name = "attempts")
	private Integer attempts;

	@XmlElement(name = "status")
	private NotificationStatus status;
	
	@XmlElement(name = "statusMessage")
	private String statusMessage;

	@XmlElement(name = "carrier")
	private String carrier;

	@XmlElement(name = "carrierConfirmation")
	private String carrierConfirmation;

	@XmlElement(name="templateId")
	private String templateId;
	

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public NotificationMethod getDeliveryMethod() {
		return deliveryMethod;
	}

	public String getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(String notificationId) {
		this.notificationId = notificationId;
	}

	public void setDeliveryMethod(NotificationMethod deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}

	public String getDeliverTo() {
		return deliverTo;
	}

	public void setDeliverTo(String to) {
		this.deliverTo = to;
	}
	
	public Integer getAttempts() {
		return attempts;
	}

	public void setAttempts(Integer attempts) {
		this.attempts = attempts;
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

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public Integer getCarrierAttempts() {
		return carrierAttempts;
	}

	public void setCarrierAttempts(Integer carrierAttempts) {
		this.carrierAttempts = carrierAttempts;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public String getCarrierConfirmation() {
		return carrierConfirmation;
	}

	public void setCarrierConfirmation(String carrierConfirmation) {
		this.carrierConfirmation = carrierConfirmation;
	}
}
