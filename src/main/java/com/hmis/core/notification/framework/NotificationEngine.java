package com.hmis.core.notification.framework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;



public class NotificationEngine implements INotificationEngine{
	
	@Autowired
	NotificationEngineContext notificationEngineContext;

	public NotificationEngineContext getNotificationEngineContext() {
		return notificationEngineContext;
	}

	public void setNotificationEngineContext(
			NotificationEngineContext notificationEngineContext) {
		this.notificationEngineContext = notificationEngineContext;
	}

	public int processNotificationWork(NotificationWork notifcationWork){
			// Do Template merging 
			NotificationThread notificationThread = new NotificationThread(notifcationWork,notificationEngineContext);
			notificationThread.run();
			return 10;
	}
}
