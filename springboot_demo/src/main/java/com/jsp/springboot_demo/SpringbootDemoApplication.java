package com.jsp.springboot_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com")
//specify package name of controller
@EntityScan(basePackages  = "com")//specify entity classes
public class SpringbootDemoApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(SpringbootDemoApplication.class, args);
	}
	

}
