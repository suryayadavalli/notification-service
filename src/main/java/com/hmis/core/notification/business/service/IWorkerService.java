package com.hmis.core.notification.business.service;

import com.hmis.core.notification.business.exception.WorkerNotFoundException;
import com.hmis.core.notification.business.service.core.IParentService;
import com.hmis.core.notification.model.WorkerLine;

public interface IWorkerService extends IParentService{
	
	public void createWorkerLine(WorkerLine workerLine) throws WorkerNotFoundException;
	public void processWorkerLine() throws WorkerNotFoundException;

}