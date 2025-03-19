package com.ty.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendEmail(String to, String subject, String body) {

		SimpleMailMessage message = new SimpleMailMessage();

		message.setTo(to);
		message.setText(body);
		message.setSubject(subject);

		javaMailSender.send(message);

		System.out.println("Email Sent");
	}

	@Autowired
	private TemplateEngine engine;
	
	public void sendEmailWithTemplate(String to, String subject, String name) throws Exception {

		MimeMessage message = javaMailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(message, true);//true is for attachements
		
		Context context=new Context();
		context.setVariable("name", name);
		
		String body = engine.process("welcome", context);
		
		helper.setTo(to);
		helper.setText(body,true);//body contains html code
		helper.setSubject(subject);
		
		helper.addAttachment("Notes", new File("C:\\Users\\asus\\Downloads\\EXERCISE(HAS_A) SOLUTION.pdf"));
		
		javaMailSender.send(message);
		
		System.out.println("email with template sent");
		
	}
}
