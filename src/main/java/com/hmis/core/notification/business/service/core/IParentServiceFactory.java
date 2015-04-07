package com.hmis.core.notification.business.service.core;

import com.hmis.core.notification.business.service.ICarrierService;
import com.hmis.core.notification.business.service.ITemplateService;

public interface IParentServiceFactory {
	
	
	ICarrierService getCarrierService();
	ITemplateService getTemplateService();
	
}
