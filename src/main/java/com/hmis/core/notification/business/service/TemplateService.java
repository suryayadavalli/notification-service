package com.hmis.core.notification.business.service;

import java.util.List;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.hmis.core.notification.business.service.core.ParentService;
import com.hmis.core.notification.framework.MergedNotificationContent;
import com.hmis.core.notification.framework.NotificationData;
import com.hmis.core.notification.framework.NotificationWork;
import com.hmis.core.notification.persistence.entity.NotificationLineEntity;
import com.hmis.core.notification.persistence.entity.TemplateHeaderEntity;
import com.hmis.core.notification.persistence.entity.TemplateLineEntity;
@Service
public class TemplateService extends ParentService implements ITemplateService{
	
	@Autowired
	VelocityEngine velocityEngine;

	public VelocityEngine getVelocityEngine() {
		return velocityEngine;
	}


	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}


	@Override
	public MergedNotificationContent merge(NotificationWork notificationWork){
			NotificationLineEntity nle = notificationWork.getNotificationLineEntity();
			NotificationData data = notificationWork.getNotificationData();
			MergedNotificationContent notificationContent = new MergedNotificationContent();
			
			TemplateHeaderEntity template = nle.getTemplate();
			Integer version = nle.getTemplateVersion();
			List<TemplateLineEntity> templateLines= daoFactory.getTemplateLineDao().findTemplate(template.getExternalId(), version);
			if(!templateLines.isEmpty()){
				TemplateLineEntity templateLine = (TemplateLineEntity) templateLines.get(0);
				if(templateLine!=null){
					 String mergedContent = VelocityEngineUtils.mergeTemplateIntoString(
							velocityEngine,
							templateLine.getLocation(),
							data.getData());
					 notificationContent.setBody(mergedContent);
					 notificationContent.setSubject(templateLine.getSubject());
				}
			}
			
			
			return notificationContent;
				
	}
	
}
