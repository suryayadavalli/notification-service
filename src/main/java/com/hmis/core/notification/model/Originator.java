package com.hmis.core.notification.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.hmis.core.notification.common.Constants.NotificationOriginatorType;

@XmlType(name = "Originator")
@XmlAccessorType(XmlAccessType.FIELD)
public class Originator {
	
	@XmlElement(name = "id")
	private String id;

	@XmlElement(name = "type")
	private NotificationOriginatorType type;
	
	@XmlElement(name = "sender")
	private String sender;
	
	@XmlElement(name = "senderFriendly")
	private String senderFriendly;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public NotificationOriginatorType getType() {
		return type;
	}
	public void setType(NotificationOriginatorType type) {
		this.type = type;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getSenderFriendly() {
		return senderFriendly;
	}
	public void setSenderFriendly(String senderFriendly) {
		this.senderFriendly = senderFriendly;
	}
	@Override
	public String toString() {
		return "Originator [id=" + id + ", sender=" + sender
				+ ", senderFriendly=" + senderFriendly + ", type=" + type + "]";
	}
}
