package com.hmis.core.notification.persistence.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.hmis.core.notification.persistence.dao.core.ParentDao;
import com.hmis.core.notification.persistence.entity.TemplateHeaderEntity;
import com.hmis.core.notification.persistence.entity.TemplateLineEntity;

public class TemplateLineDao extends ParentDao implements ITemplateLineDao{
	
	
	public TemplateLineDao() {
		super();
	}
	
	@Override
	public TemplateHeaderEntity findTemplateHeader(String externalId){
		DetachedCriteria query = DetachedCriteria.forClass(TemplateHeaderEntity.class);
		query.add(Restrictions.eq("externalId",externalId));
		List<TemplateHeaderEntity> list = (List<TemplateHeaderEntity>) findByCriteria(query);
		if(!list.isEmpty()) return (TemplateHeaderEntity) list.get(0);
		return null;
	}
	
	@Override
	public List<TemplateLineEntity> findTemplate(String externalId, Integer version) {
		DetachedCriteria query = DetachedCriteria.forClass(TemplateLineEntity.class);
		query.createAlias("templateHeader", "templateHeader");
		query.add(Restrictions.eq("templateHeader.externalId",externalId));

		//if version is passed get the template for the version or get the latest versioned template
		if(version==null) query.addOrder(Order.desc("version"));
			else
		query.add(Restrictions.eq("version", version));
		
		return (List<TemplateLineEntity>) findByCriteria(query);

	}

}
