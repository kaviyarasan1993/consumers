package org.egov.lams;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application extends Thread{
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}