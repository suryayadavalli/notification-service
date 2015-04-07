package com.hmis.core.notification.scheduler.dao;

import java.util.List;

import com.hmis.core.notification.persistence.dao.core.IQueryExecutor;
import com.hmis.core.notification.persistence.entity.WorkerLineEntity;

public interface IWorkerLineDao extends IQueryExecutor{
	
	public List<WorkerLineEntity> findUnprocessedByExternalId(String exernalId);

}
