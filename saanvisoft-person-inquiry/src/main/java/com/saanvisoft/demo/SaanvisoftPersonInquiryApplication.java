package com.saanvisoft.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan("com.saanvisoft.demo.*")   
public class SaanvisoftPersonInquiryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaanvisoftPersonInquiryApplication.class, args);
	}

}
