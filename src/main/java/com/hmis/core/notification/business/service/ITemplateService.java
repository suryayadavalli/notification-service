package com.hmis.core.notification.business.service;

import com.hmis.core.notification.business.service.core.IParentService;
import com.hmis.core.notification.framework.MergedNotificationContent;
import com.hmis.core.notification.framework.NotificationWork;

public interface ITemplateService extends IParentService{
	
	
	public MergedNotificationContent merge(NotificationWork notificationWork);

}