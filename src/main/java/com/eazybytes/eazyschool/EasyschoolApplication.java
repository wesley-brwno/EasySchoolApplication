package com.eazybytes.eazyschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
public class EasyschoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyschoolApplication.class, args);
	}

}