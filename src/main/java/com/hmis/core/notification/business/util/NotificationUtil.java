package com.hmis.core.notification.business.util;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;

import com.hmis.core.notification.business.service.core.ParentServiceFactory;
import com.hmis.core.notification.carrier.Workers;
import com.hmis.core.notification.common.Constants.NotificationMethod;
import com.hmis.core.notification.common.Constants.NotificationOriginatorType;
import com.hmis.core.notification.model.NotificationHeader;
import com.hmis.core.notification.model.Originator;
import com.hmis.core.notification.model.Recipient;
import com.hmis.core.notification.model.Template;
import com.hmis.core.notification.model.WorkerLine;


public abstract class NotificationUtil implements INotificationUtil {
	
	@Autowired
    protected HashMap<String,NotificationParams> notificationParams;
	

 
	 public HashMap<String,NotificationParams> getNotificationParams() {
		return notificationParams;
	}

	public void setNotificationParams(HashMap<String,NotificationParams> notificationParams) {
		this.notificationParams = notificationParams;
	}

	public ParentServiceFactory getServiceFactory() {
		return serviceFactory;
	}

	public void setServiceFactory(ParentServiceFactory serviceFactory) {
		this.serviceFactory = serviceFactory;
	}

	@Autowired
	 ParentServiceFactory serviceFactory;
	 

	
	protected Originator createOriginator(String receiverEmail, String senderEmail, String senderFriendlyName,NotificationOriginatorType not) {
		Originator originator = new Originator();
		originator.setId(receiverEmail);
		originator.setType(not);
		originator.setSender(senderEmail);
		originator.setSenderFriendly(senderFriendlyName);
		return originator;
	}

	protected Template createTemplate(String templateId) {
		Template template = new Template();
		template.setExternalId(templateId);
		return template;
	}

	protected Recipient createRecipient(String username, String deliverTo, String templateId,NotificationMethod nm) {
		Recipient recipient = new Recipient();
		recipient.setUsername(username);		
		recipient.setDeliveryMethod(nm);
		recipient.setDeliverTo(deliverTo);
		recipient.setTemplateId(templateId);
		return recipient;
	}
	
	protected  void createWorkerLine(NotificationHeader nh){
		WorkerLine wl = new WorkerLine();
		wl.setWorkerHeaderId(Workers.NOTIFICATION_WORKER.toString());
		wl.setInput(nh.toString());
		serviceFactory.getWorkerService().createWorkerLine(wl);
	}
}
