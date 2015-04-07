package com.hmis.core.notification.persistence.dao.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hmis.core.notification.persistence.dao.INotificationHeaderDao;
import com.hmis.core.notification.persistence.dao.INotificationLineDao;
import com.hmis.core.notification.persistence.dao.ITemplateLineDao;
import com.hmis.core.notification.scheduler.dao.IWorkerHeaderDao;
import com.hmis.core.notification.scheduler.dao.IWorkerLineDao;

@Component
public class ParentDaoFactory implements IParentDaoFactory {
	

	@Autowired
	private IWorkerLineDao workerLineDao;

	public IWorkerLineDao getWorkerLineDao() {
		return workerLineDao;
	}

	public void setWorkerLineDao(IWorkerLineDao workerLineDao) {
		this.workerLineDao = workerLineDao;
	}

	@Autowired
	private IWorkerHeaderDao workerHeaderDao;

	public IWorkerHeaderDao getWorkerHeaderDao() {
		return workerHeaderDao;
	}

	public void setWorkerHeaderDao(IWorkerHeaderDao workerHeaderDao) {
		this.workerHeaderDao = workerHeaderDao;
	}

	@Autowired
	private INotificationHeaderDao notificationHeaderDao;

	public INotificationHeaderDao getNotificationHeaderDao() {
		return notificationHeaderDao;
	}

	public void setNotificationHeaderDao(
			INotificationHeaderDao notificationHeaderDao) {
		this.notificationHeaderDao = notificationHeaderDao;
	}

	@Autowired
	private INotificationLineDao notificationLineDao;

	public INotificationLineDao getNotificationLineDao() {
		return notificationLineDao;
	}

	public void setNotificationLineDao(INotificationLineDao notificationLineDao) {
		this.notificationLineDao = notificationLineDao;
	}

	@Autowired
	private ITemplateLineDao templateLineDao;

	public ITemplateLineDao getTemplateLineDao() {
		return templateLineDao;
	}

	public void setTemplateLineDao(ITemplateLineDao templateLineDao) {
		this.templateLineDao = templateLineDao;
	}
	
	
}
