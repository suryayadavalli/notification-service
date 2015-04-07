package com.hmis.core.notification.persistence.dao;

import java.util.List;

import com.hmis.core.notification.persistence.dao.core.IParentDao;
import com.hmis.core.notification.persistence.entity.TemplateHeaderEntity;
import com.hmis.core.notification.persistence.entity.TemplateLineEntity;

public interface ITemplateLineDao extends IParentDao{
	
	public List<TemplateLineEntity> findTemplate(String externalId,Integer version);
	public TemplateHeaderEntity findTemplateHeader(String externalId);

}
