package com.hmis.core.notification.business.service;

import com.hmis.core.notification.business.service.core.IParentService;


public interface INotificationWorker  extends IParentService  {
	
	
	
	public void processWorkerLine() throws Exception;
	

}
