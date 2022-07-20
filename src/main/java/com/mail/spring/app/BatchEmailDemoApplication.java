package com.mail.spring.app;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class BatchEmailDemoApplication {

	@Autowired
	private MailSenderService service;
	public static void main(String[] args) {
		SpringApplication.run(BatchEmailDemoApplication.class, args);
	}
     
	@EventListener(ApplicationReadyEvent.class)
	public void triggermail() throws MessagingException {
	
//		service.sendMail("officialaginthomas@gmail.com", "Hello how are you", "subject");
		
		service.sendwithAttachment("officialaginthomas@gmail.com", "Message with attachment", "Sub", "E:\\\\Mmovies\\\\Degree.pdf");
		
	}
}
