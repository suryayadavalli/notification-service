package com.hmis.core.notification.rest.endpoint;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hmis.core.notification.business.service.INotificationService;
import com.hmis.core.notification.model.Notification;
import com.hmis.core.notification.rest.endpoint.core.ParentWebservice;
