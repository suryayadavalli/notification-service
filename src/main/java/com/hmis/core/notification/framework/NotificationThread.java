package com.hmis.core.notification.framework;

import com.hmis.core.notification.carrier.CarrierNotification;
import com.hmis.core.notification.persistence.entity.NotificationLineEntity;


public class NotificationThread {

	
	NotificationWork notificationWork;
	
	
	NotificationEngineContext notificationEngineContext;
	
	public NotificationEngineContext getNotificationEngineContext() {
		return notificationEngineContext;
	}

	
	public void setNotificationEngineContext(
			NotificationEngineContext notificationEngineContext) {
		this.notificationEngineContext = notificationEngineContext;
	}


	public NotificationWork getNotificationWork() {
		return notificationWork;
	}

	
	public void setNotificationWork(NotificationWork notificationWork) {
		this.notificationWork = notificationWork;
	}


   
	public NotificationThread(NotificationWork notificationWork, NotificationEngineContext notificationEngineContext)	{
		this.notificationWork = notificationWork;
		this.notificationEngineContext = notificationEngineContext;
	}
	
	
	public void run() {
		MergedNotificationContent notificationContent = getNotificationEngineContext().getTemplateService().merge(notificationWork);
		CarrierNotification carrierNotification = createCarrierNotification(notificationWork,notificationContent);
		getNotificationEngineContext().getCarrierService().send(carrierNotification,notificationWork.getNotificationLineEntity());	
	}
	
	
	private CarrierNotification createCarrierNotification(NotificationWork notificationWork,MergedNotificationContent notificationContent)  {
		NotificationLineEntity notificationLineEntity = notificationWork.getNotificationLineEntity();
		CarrierNotification carrierNotification = new CarrierNotification();
		carrierNotification.setRecipient(notificationLineEntity.getDeliverTo());
		carrierNotification.setSenderFriendly(notificationWork.getSenderFriendly());
		carrierNotification.setSender(notificationWork.getSender());
		carrierNotification.setRecipient(notificationLineEntity.getDeliverTo());
		carrierNotification.setContent(notificationContent.getBody());
		carrierNotification.setSubject(notificationContent.getSubject());
		carrierNotification.setId(notificationLineEntity.getId().toString());
		return carrierNotification;
	}
	
	
	
}
