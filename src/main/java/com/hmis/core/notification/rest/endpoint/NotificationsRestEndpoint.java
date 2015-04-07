package com.hmis.core.notification.rest.endpoint;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hmis.core.notification.business.service.INotificationService;
import com.hmis.core.notification.model.Notification;
import com.hmis.core.notification.rest.endpoint.core.ParentWebservice;
@Controller@RequestMapping("/notifications")public class NotificationsRestEndpoint extends ParentWebservice {	@Autowired	private INotificationService notificationService;		public void setNotificationService(INotificationService notificationService)	{		this.notificationService = notificationService;	}		public Notification createNotificationJob(@RequestBody Notification notification, HttpServletRequest request) throws Exception {		notificationService.createNotificationJob(notification);		Notification response = new Notification();		response.setExternalId(notification.getExternalId());		response.setStatus(notification.getStatus());				return response;	}}