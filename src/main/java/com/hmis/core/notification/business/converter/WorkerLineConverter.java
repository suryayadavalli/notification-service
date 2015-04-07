package com.hmis.core.notification.business.converter;

import com.hmis.core.notification.model.WorkerLine;
import com.hmis.core.notification.persistence.entity.WorkerLineEntity;

public class WorkerLineConverter {

	/* MODEL TO ENTITY CONVERSIONS */
	public static WorkerLineEntity convertModelToEntity(WorkerLine workerLineModel,WorkerLineEntity workerLineEntity) {
		return workerLineEntity;
	}



	public static WorkerLine convertEntityToModel(WorkerLineEntity workerLineEntity) {
		WorkerLine workerLine = new WorkerLine();
		workerLine.setInput(workerLineEntity.getLineInput());
		workerLine.setWorkerLineId(workerLineEntity.getExternalId());
		return workerLine;
	}

}
