package com.hmis.core.notification.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hmis.core.notification.business.service.core.ParentService;
import com.hmis.core.notification.carrier.CarrierFactory;
import com.hmis.core.notification.carrier.CarrierNotification;
import com.hmis.core.notification.carrier.ICarrier;
import com.hmis.core.notification.persistence.entity.NotificationLineEntity;

@Service
public class CarrierService extends ParentService implements ICarrierService{
	
	@Autowired
	CarrierFactory carrierFactory;
	
	
	public CarrierFactory getCarrierFactory() {
		return carrierFactory;
	}

	public void setCarrierFactory(CarrierFactory carrierFactory) {
		this.carrierFactory = carrierFactory;
	}

	@Override
	public void send(CarrierNotification carrierNotification, NotificationLineEntity notificationLineEntity){
		ICarrier carrier = carrierFactory.getCarrier(notificationLineEntity.getDeliveryMethod());
		carrier.send(carrierNotification);
	}
	
}
