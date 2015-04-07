package com.hmis.core.notification.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.hmis.core.notification.business.service.CarrierService;
import com.hmis.core.notification.business.service.ICarrierService;
import com.hmis.core.notification.business.service.INotificationWorker;
import com.hmis.core.notification.business.service.ITemplateService;
import com.hmis.core.notification.business.service.IWorkerService;
import com.hmis.core.notification.business.service.NotificationWorker;
import com.hmis.core.notification.business.service.TemplateService;
import com.hmis.core.notification.business.service.WorkerService;
import com.hmis.core.notification.business.service.core.IParentServiceFactory;
import com.hmis.core.notification.business.service.core.ParentServiceFactory;
import com.hmis.core.notification.carrier.EMailCarrier;
import com.hmis.core.notification.carrier.ICarrier;
import com.hmis.core.notification.carrier.SMSCarrier;
import com.hmis.core.notification.framework.INotificationEngine;
import com.hmis.core.notification.framework.INotificationEngineContext;
import com.hmis.core.notification.framework.NotificationEngine;
import com.hmis.core.notification.framework.NotificationEngineContext;
import com.hmis.core.notification.framework.NotificationThread;
import com.hmis.core.notification.persistence.dao.INotificationHeaderDao;
import com.hmis.core.notification.persistence.dao.INotificationLineDao;
import com.hmis.core.notification.persistence.dao.ITemplateLineDao;
import com.hmis.core.notification.persistence.dao.NotificationHeaderDao;
import com.hmis.core.notification.persistence.dao.NotificationLineDao;
import com.hmis.core.notification.persistence.dao.TemplateLineDao;
import com.hmis.core.notification.persistence.dao.core.IParentDaoFactory;
import com.hmis.core.notification.persistence.dao.core.ParentDaoFactory;
import com.hmis.core.notification.scheduler.dao.IWorkerHeaderDao;
import com.hmis.core.notification.scheduler.dao.IWorkerLineDao;
import com.hmis.core.notification.scheduler.dao.WorkerHeaderDao;
import com.hmis.core.notification.scheduler.dao.WorkerLineDao;


@Configuration
@ComponentScan(value={"com.broadcom.plm.notification.business.service","com.broadcom.plm.notification.framework"})
@ImportResource({"com/broadcom/plm/persistence/dao-config.xml", "com/broadcom/plm/velocity/velocity-config.xml", 
								"com/broadcom/plm/notification/carrier-config.xml", 
								"com/broadcom/plm/workers/workers-config.xml",
								"com/broadcom/plm/notification/notification-config.xml"})
@EnableScheduling
public class SpringConfig  {

	@Bean(name="carrierService")
	    public ICarrierService getCarrierService(){
	        return new CarrierService();
	    }
	 
	 @Bean(name="templateService")
	    public ITemplateService getTemplateService(){
	        return new TemplateService();
	    }
	 
	 @Bean(name="workerService")
	    public IWorkerService getWorkerService(){
		 return new WorkerService();
	 }
	 
	 @Bean(name="emailCarrier")
	    public ICarrier getEMailCarrier(){
		 return new EMailCarrier();
	 }
	 
	 @Bean(name="smsCarrier")
	    public ICarrier getSMSCarrier(){
		 return new SMSCarrier();
	 }
	 
	 @Bean(name="notificationEngine")
	 public INotificationEngine getNotificationEngine(){
		 return new NotificationEngine();
	 }
	 
	 @Bean(name="notificationEngineContext")
	 public INotificationEngineContext getNotificationEngineContext(){
		 return new NotificationEngineContext();
	 }
	
	 @Bean(name="serviceFactory")
	 public IParentServiceFactory getServiceFactory(){
		 return new ParentServiceFactory();
	 }
	 

	  
	 @Bean(name="workerHeaderDao")
	 public IWorkerHeaderDao getWorkerHeaderDao(){
		 return new WorkerHeaderDao();
	 }
	 
	 @Bean(name="workerLineDao")
	 public IWorkerLineDao getWorkerLineDao(){
		 return new WorkerLineDao();
	 }
	 

	 
	 @Bean(name="notificationLineDao")
	 public INotificationLineDao getNotificationLineDao(){
		 return new NotificationLineDao();
	 }
	 
	 @Bean(name="notificationHeaderDao")
	 public INotificationHeaderDao getNotificationHeaderDao(){
		 return new NotificationHeaderDao();
	 }
	 
	 @Bean(name="templateLineDao")
	 public ITemplateLineDao getTemplateLineDao(){
		 return new TemplateLineDao();
	 }
	 
	 @Bean(name="daoFactory")
	 public IParentDaoFactory getParentDaoFactory(){
		 return new ParentDaoFactory();
	 }

	 @Bean(name="notificationWorker")
	 public INotificationWorker getNotificationWorker(){
		 return new NotificationWorker();
	 }

    
}
