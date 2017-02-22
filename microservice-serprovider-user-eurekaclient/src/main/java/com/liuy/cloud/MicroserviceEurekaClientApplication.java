package com.liuy.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 * 可参考
 * http://cloud.spring.io/spring-cloud-static/Camden.SR1/#_registering_with_eureka
 * 
 * */
@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient
public class MicroserviceEurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceEurekaClientApplication.class, args);
	}
}
