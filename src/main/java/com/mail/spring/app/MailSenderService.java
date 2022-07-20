package com.mail.spring.app;

import java.io.File;
import java.nio.file.FileSystem;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailSenderService {
	
	@Autowired
	private JavaMailSender mailsender;
	
	public void sendMail(String toEmail,
			              String subject,
			              String body) {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom("aginth90@gmail.com");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);
		
	    mailsender.send(message);
	    
	    System.out.println("Send...");
		
	}

	public void sendwithAttachment(String toEmail,String subject,
			String body,String attachment) throws MessagingException {
		MimeMessage mimeMessage=mailsender.createMimeMessage();
		
		MimeMessageHelper mimeMessageHelper=
				new MimeMessageHelper(mimeMessage, true);
		
		mimeMessageHelper.setFrom("aginth90@gmail.com");
		mimeMessageHelper.setTo(toEmail);
		mimeMessageHelper.setText(body);
		mimeMessageHelper.setSubject(subject);
		
		FileSystemResource fileSystemResource=
				new FileSystemResource(new File(attachment));
		
		mimeMessageHelper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);
		mailsender.send(mimeMessage);
		System.out.println("Send 2...");
		
		
		
		
	}
}
