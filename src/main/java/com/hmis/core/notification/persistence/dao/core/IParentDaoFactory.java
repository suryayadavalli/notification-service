package com.hmis.core.notification.persistence.dao.core;

import com.hmis.core.notification.persistence.dao.INotificationHeaderDao;
import com.hmis.core.notification.persistence.dao.INotificationLineDao;
import com.hmis.core.notification.persistence.dao.ITemplateLineDao;
import com.hmis.core.notification.scheduler.dao.IWorkerHeaderDao;
import com.hmis.core.notification.scheduler.dao.IWorkerLineDao;



public interface IParentDaoFactory {
	
	public IWorkerLineDao getWorkerLineDao();
	public IWorkerHeaderDao getWorkerHeaderDao();
	public INotificationHeaderDao getNotificationHeaderDao();
	public INotificationLineDao getNotificationLineDao();
	public ITemplateLineDao getTemplateLineDao();
	
}