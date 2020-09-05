package com.dxc.studentmarks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class StudentMarksServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentMarksServiceApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
//	Spring Bean scopes
//	+ Singleton default
//	+ Prototype
//	+ WebApplication context

}
