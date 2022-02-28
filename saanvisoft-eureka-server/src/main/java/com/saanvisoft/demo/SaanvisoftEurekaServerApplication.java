package com.saanvisoft.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SaanvisoftEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaanvisoftEurekaServerApplication.class, args);
	}

}
