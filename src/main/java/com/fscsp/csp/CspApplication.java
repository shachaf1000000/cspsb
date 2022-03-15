package com.fscsp.csp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableScheduling
@EnableWebMvc
public class CspApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=SpringApplication.run(CspApplication.class, args);
		System.out.println("spring is running!");
		System.out.println("the end!");
	}
}
