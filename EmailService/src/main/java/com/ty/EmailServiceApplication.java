package com.ty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.ty.service.EmailService;

@SpringBootApplication
public class EmailServiceApplication {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext run = SpringApplication.run(EmailServiceApplication.class, args);

		EmailService bean = run.getBean(EmailService.class);

		String to = "saurabhpatade1302@gmail.com";
		String subject = "Hi this is from Spring boot batch";
		
		String body = "Since you been not attending class regulerly you wont be allowed for requirements";

//		bean.sendEmail(to, subject, body);
		
		bean.sendEmailWithTemplate(to, subject, "Saurabh");
		
	}

}
