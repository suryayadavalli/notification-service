package com.hmis.core.notification.model;

import org.apache.commons.lang.builder.ToStringBuilder;

public abstract class ClientModel {
	
	@Override
	public String toString() {
		try{
			return ToStringBuilder.reflectionToString(this);
		}catch(Exception e){ }
		return null;
	}
	
}
