package com.hmis.core.notification.business.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hmis.core.notification.business.exception.WorkerNotFoundException;
import com.hmis.core.notification.business.service.core.ParentService;
import com.hmis.core.notification.common.Constants;
import com.hmis.core.notification.common.CoreUtil;
import com.hmis.core.notification.model.WorkerLine;
import com.hmis.core.notification.persistence.entity.WorkerHeaderEntity;
import com.hmis.core.notification.persistence.entity.WorkerLineEntity;

@Service
@Transactional
public class WorkerService extends ParentService implements IWorkerService{
	
	@Override
	public void createWorkerLine(WorkerLine workerLine) throws WorkerNotFoundException {

		WorkerHeaderEntity workerHeader = loadWorkerHeader(workerLine);
		WorkerLineEntity workerLineEntity = new WorkerLineEntity();
		workerLineEntity.setCurrRetry(0);
		workerLineEntity.setExternalId(CoreUtil.createUniqueID(false));
		workerLineEntity.setWorkerHeader(workerHeader);
		workerLineEntity.setMaxRetry(workerHeader.getMaxRetry());
		workerLineEntity.setRetryInterval(workerHeader.getRetryInterval());
		workerLineEntity.setStatus(Constants.JOB_CREATED);
		workerLineEntity.setLineInput(workerLine.getInput());
		daoFactory.getWorkerLineDao().insert(workerLineEntity);
		workerLine.setWorkerLineId(workerLineEntity.getExternalId());
	}
	
	
	@Override
	public void processWorkerLine() throws WorkerNotFoundException
	{		
		
	}
	
	private WorkerHeaderEntity loadWorkerHeader(WorkerLine workerLine) throws WorkerNotFoundException{
		List<WorkerHeaderEntity> workerHeaderEntityList = daoFactory.getWorkerHeaderDao().findByExternalId(workerLine.getWorkerHeaderId());
		if( workerHeaderEntityList.isEmpty())	throw new WorkerNotFoundException();
		return workerHeaderEntityList.get(0);		
	}
	
}
