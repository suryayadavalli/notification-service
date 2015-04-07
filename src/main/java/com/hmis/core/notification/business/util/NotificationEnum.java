package com.hmis.core.notification.business.util;

public enum NotificationEnum {
	REPORT_NOTIFICATION("REPORT_NOTIFICATION");

	private String notificationParamType;
 
	private NotificationEnum(String s) {
		notificationParamType = s;
	}
 
	public String getNotificationParamType() {
		return notificationParamType;
	}
}