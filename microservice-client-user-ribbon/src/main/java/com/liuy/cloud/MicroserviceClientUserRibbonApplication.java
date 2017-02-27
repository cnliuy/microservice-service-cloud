package com.liuy.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.liuy.config.TestConfiguration;

@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "microservice-provider-user", configuration = TestConfiguration.class)
//microservice-serprovider-user-eurekaclient 对应 microservice-serprovider-user-eurekaclient 项目的
//ApplicationName  如图 1.png

@RibbonClient(name = "microservice-serprovider-user-eurekaclient", configuration = TestConfiguration.class)
public class MicroserviceClientUserRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceClientUserRibbonApplication.class, args);
	}
	
	
	 
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
}
