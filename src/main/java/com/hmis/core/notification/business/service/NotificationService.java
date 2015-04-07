package com.hmis.core.notification.business.service;

import java.util.ArrayList;

import com.hmis.core.notification.business.util.NotificationEnum;
import com.hmis.core.notification.business.util.NotificationParams;
import com.hmis.core.notification.business.util.NotificationUtil;
import com.hmis.core.notification.common.Constants.NotificationMethod;
import com.hmis.core.notification.common.Constants.NotificationOriginatorType;
import com.hmis.core.notification.framework.NotificationData;
import com.hmis.core.notification.model.Notification;
import com.hmis.core.notification.model.NotificationHeader;
import com.hmis.core.notification.model.Originator;
import com.hmis.core.notification.model.Recipient;

public class NotificationService extends NotificationUtil implements INotificationService {

	@Override
	public void createNotificationJob(Notification notification) {
		
		NotificationEnum type = NotificationEnum.valueOf(notification.getType());
		//To do - surya 03/26 -throw exception if wrong value is passed.
		NotificationParams nps = notificationParams.get(type.toString());

		NotificationHeader header = new NotificationHeader();
		Originator originator = createOriginator(nps.getSenderEmailAddress(), nps.getSenderEmailAddress(),
				nps.getSenderFriendlyName(), NotificationOriginatorType.USER);

		NotificationMethod method = NotificationMethod.valueOf(notification.getMethod());
				
		ArrayList<Recipient> recipents = new ArrayList<Recipient>();
		for(String recipient : notification.getRecipients()){
				Recipient recipent = createRecipient(recipient,
						recipient, nps.getTemplateId(),
						method);
				recipents.add(recipent);
		}
		
		NotificationData data = new NotificationData();
		/*
		NotificationData data = new NotificationData();
		data.addDataElement("reportName", reportName);
		*/
		
		header.setOriginator(originator);
		// there could be multiple recipients - if we have more subscribers for the report.
		header.setRecipients(recipents);
		header.setNotificationData(data);

		createWorkerLine(header);
		
	}

	
}
