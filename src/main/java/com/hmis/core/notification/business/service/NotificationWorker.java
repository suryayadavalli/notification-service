package com.hmis.core.notification.business.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.hmis.core.notification.business.converter.NotificationConverter;
import com.hmis.core.notification.business.converter.WorkerLineConverter;
import com.hmis.core.notification.business.service.core.ParentService;
import com.hmis.core.notification.carrier.Workers;
import com.hmis.core.notification.common.Constants;
import com.hmis.core.notification.common.CoreUtil;
import com.hmis.core.notification.common.Constants.NotificationStatus;
import com.hmis.core.notification.framework.NotificationEngine;
import com.hmis.core.notification.framework.NotificationWork;
import com.hmis.core.notification.model.NotificationHeader;
import com.hmis.core.notification.model.Recipient;
import com.hmis.core.notification.model.WorkerLine;
import com.hmis.core.notification.persistence.entity.NotificationHeaderEntity;
import com.hmis.core.notification.persistence.entity.NotificationLineEntity;
import com.hmis.core.notification.persistence.entity.TemplateHeaderEntity;
import com.hmis.core.notification.persistence.entity.WorkerLineEntity;

@Service
@EnableScheduling
public class NotificationWorker  extends ParentService implements INotificationWorker  {
	
	
	NotificationEngine notificationEngine;
   
	@Bean
	public NotificationEngine getNotificationEngine() {
		return notificationEngine;
	}

	public void setNotificationEngine(NotificationEngine notificationEngine) {
		this.notificationEngine = notificationEngine;
	}

	@Scheduled(fixedRate=5)
	public void processWorkerLine() throws Exception{
		
		List<WorkerLineEntity> workerLineEntities=  daoFactory.getWorkerLineDao().findUnprocessedByExternalId(Workers.NOTIFICATION_WORKER.getWorker());
		Iterator<WorkerLineEntity> wleIterator = workerLineEntities.iterator();
		
		while(wleIterator.hasNext()){
			WorkerLineEntity wle = wleIterator.next();
			  WorkerLine workerLine = WorkerLineConverter.convertEntityToModel(wle);
			  
			  //When you create a worker line request, you create a request that has the Input matches with Notification header
			  NotificationHeader headerModel = CoreUtil.convertJSONtoJava(workerLine.getInput(), NotificationHeader.class);
			  
			  // This is header entity for all recipients
			  NotificationHeaderEntity notifcationHeaderEntity = NotificationConverter.convertModelToEntity(headerModel, new NotificationHeaderEntity());
			  
			  notifcationHeaderEntity.setStatus(NotificationStatus.INIT.toString());
	
			  	daoFactory.getNotificationHeaderDao().create(notifcationHeaderEntity);
				
				ArrayList<NotificationWork> workList = new ArrayList<NotificationWork>();
				// This is individual recipient 
				for(Recipient recipient : headerModel.getRecipients())	{
					NotificationLineEntity notificationLineEntity= NotificationConverter.toNotificationLineEntity(recipient);
					notificationLineEntity.setNotificationHeaderEntity(notifcationHeaderEntity);
					notificationLineEntity.setCarrierAttempts(0);
					notificationLineEntity.setAttempts(0);
					notificationLineEntity.setExternalId(CoreUtil.createUniqueID(false));
					notificationLineEntity.setStatusMessage(CoreUtil.emptyString());
					
					// If we have any templates set here.
					TemplateHeaderEntity thEntity = daoFactory.getTemplateLineDao().findTemplateHeader(recipient.getTemplateId());
					if(thEntity!=null)  notificationLineEntity.setTemplate(thEntity);
					
					notificationLineEntity.setStatus(NotificationStatus.INIT);
					daoFactory.getNotificationLineDao().create(notificationLineEntity);
	
					NotificationWork worker = new NotificationWork();
					worker.setNotificationLineEntity(notificationLineEntity);
					worker.setSender(notifcationHeaderEntity.getSender());
					//notification data should be set here to Notification work.
					worker.setSenderFriendly(headerModel.getOriginator().getSenderFriendly());
					worker.setNotificationData(headerModel.getNotificationData());
					notificationEngine.processNotificationWork(worker);
						
						wle.setStatus(Constants.JOB_SUCCEEDED);
						daoFactory.getWorkerLineDao().update(wle);

				}
			
		}
	}
	

}
