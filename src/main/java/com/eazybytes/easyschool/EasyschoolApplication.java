package com.eazybytes.easyschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
public class EasyschoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyschoolApplication.class, args);
	}

}
