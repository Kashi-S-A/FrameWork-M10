package com.ty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.ty.util.TestEnv;

@SpringBootApplication
public class H2DbApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(H2DbApplication.class, args);
		
		TestEnv bean = run.getBean(TestEnv.class);
		System.out.println(bean.getMessage());
	}

}
