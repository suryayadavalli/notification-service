package com.hmis.core.notification.scheduler.dao;import java.util.List;import com.hmis.core.notification.persistence.dao.core.IQueryExecutor;import com.hmis.core.notification.persistence.entity.WorkerHeaderEntity;public interface IWorkerHeaderDao  extends IQueryExecutor{ 	public List<WorkerHeaderEntity> findByExternalId(String externalId);	}