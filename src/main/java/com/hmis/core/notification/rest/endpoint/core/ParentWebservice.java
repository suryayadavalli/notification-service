package com.hmis.core.notification.rest.endpoint.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.hmis.core.notification.business.service.core.IParentServiceFactory;
import com.hmis.core.notification.model.ErrorResponse;

public class ParentWebservice implements IParentWebservice {
	
	@Autowired
	protected IParentServiceFactory serviceFactory;

	public IParentServiceFactory getServiceFactory() {
		return serviceFactory;
	}

	public void setServiceFactory(IParentServiceFactory serviceFactory) {
		this.serviceFactory = serviceFactory;
	}
	
	@ExceptionHandler(Throwable.class)
	public ModelAndView processException(Throwable throwable, HttpServletRequest request, HttpServletResponse response) {
		WebserviceExceptionHandler wsExceptionHandler = new WebserviceExceptionHandler(throwable);
		wsExceptionHandler.processException();
		XmlRootElement rootElement= AnnotationUtils.findAnnotation(ErrorResponse.class, XmlRootElement.class);
		return  new ModelAndView("", rootElement.name(),wsExceptionHandler.getErrorResponse());
	}

}
