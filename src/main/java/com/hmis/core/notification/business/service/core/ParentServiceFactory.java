package com.hmis.core.notification.business.service.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hmis.core.notification.business.service.CarrierService;
import com.hmis.core.notification.business.service.ICarrierService;
import com.hmis.core.notification.business.service.INotificationWorker;
import com.hmis.core.notification.business.service.ITemplateService;
import com.hmis.core.notification.business.service.IWorkerService;
import com.hmis.core.notification.business.service.TemplateService;


@Component
public class ParentServiceFactory  implements IParentServiceFactory {

	@Autowired
	CarrierService carrierService;
	
	
	public ICarrierService getCarrierService() {
		return carrierService;
	}

	public void setCarrierService(CarrierService carrierService) {
		this.carrierService = carrierService;
	}

	@Autowired
	TemplateService templateService;


	public TemplateService getTemplateService() {
		return templateService;
	}

	public void setTemplateService(TemplateService templateService) {
		this.templateService = templateService;
	}
	
	@Autowired
	IWorkerService workerService;

	
	public IWorkerService getWorkerService() {
		return workerService;
	}

	public void setWorkerService(IWorkerService workerService) {
		this.workerService = workerService;
	}
	
	@Autowired
	INotificationWorker notificationWorker;


	public INotificationWorker getNotificationWorker() {
		return notificationWorker;
	}

	public void setNotificationWorker(INotificationWorker notificationWorker) {
		this.notificationWorker = notificationWorker;
	}
	
	
	
}

