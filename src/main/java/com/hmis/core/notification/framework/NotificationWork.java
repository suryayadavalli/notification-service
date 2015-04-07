package com.hmis.core.notification.framework;

import com.hmis.core.notification.persistence.entity.NotificationLineEntity;



public class NotificationWork {
	
	private NotificationLineEntity notificationLineEntity;
	private NotificationData notificationData;
	private String senderFriendly;
	private String sender;
	
	

	public NotificationLineEntity getNotificationLineEntity() {
		return notificationLineEntity;
	}
	public void setNotificationLineEntity(
			NotificationLineEntity notificationLineEntity) {
		this.notificationLineEntity = notificationLineEntity;
	}
	
	


	public NotificationData getNotificationData() {
		return notificationData;
	}
	public void setNotificationData(NotificationData notificationData) {
		this.notificationData = notificationData;
	}
	public String getSenderFriendly() {
		return senderFriendly;
	}
	public void setSenderFriendly(String senderFriendly) {
		this.senderFriendly = senderFriendly;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}


}
