package com.hmis.core.notification.carrier;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;


public class EMailCarrier  extends JavaMailSenderImpl implements ICarrier{
	
	
	
	public void send(final CarrierNotification carrierNotification){
		 MimeMessagePreparator preparator = new MimeMessagePreparator() {
	            public void prepare(MimeMessage mimeMessage) throws Exception {
	               MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
	               message.setTo(carrierNotification.getRecipient());
	               message.setFrom(carrierNotification.getSender());
	               message.setSubject(carrierNotification.getSubject());
	               message.setText(carrierNotification.getContent(), true);
	            }
	         };
	        this.send(preparator);
	}
}
