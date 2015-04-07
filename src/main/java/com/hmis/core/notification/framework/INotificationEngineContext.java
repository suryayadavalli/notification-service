package com.hmis.core.notification.framework;

import com.hmis.core.notification.business.service.ICarrierService;
import com.hmis.core.notification.business.service.ITemplateService;




public interface INotificationEngineContext{
	
	
	public ICarrierService getCarrierService();
	public ITemplateService getTemplateService();
	

}
