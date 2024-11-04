package com.atyas.jobmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class JobmicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobmicroserviceApplication.class, args);
	}

}
