package com.hmis.core.notification.carrier;

public class CarrierNotification {
	
	private String id;
	private String recipient;
	private String subject;
	private String content;
	private String sender;
	private String senderFriendly;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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

}
