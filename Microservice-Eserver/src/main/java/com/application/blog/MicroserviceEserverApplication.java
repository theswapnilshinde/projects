package com.application.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroserviceEserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceEserverApplication.class, args);
	}

}
