package com.hmis.core.notification.business.service;

import com.hmis.core.notification.business.service.core.IParentService;
import com.hmis.core.notification.carrier.CarrierNotification;
import com.hmis.core.notification.persistence.entity.NotificationLineEntity;

public interface ICarrierService extends IParentService{
	
	
	public void send(CarrierNotification carrierNotification, NotificationLineEntity notificationLineEntity);

}