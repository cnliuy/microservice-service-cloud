package com.liuy.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.liuy.cloud.entity.User;

@RestController
public class ClientuserController {
	
  //实例化一个 restTemplate 	
  @Autowired
  private RestTemplate restTemplate;
  
  @Autowired
  private LoadBalancerClient loadBalancerClient;

  //@Value("${user.userServicePath}")
  //private String userServicePath;

  //--  http://localhost:8010/movie/1
  // in ribbon need change microservice-serprovider-user-eurekaclient
  @GetMapping("/movie/{id}")
  public User findById(@PathVariable Long id) {

	ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-serprovider-user-eurekaclient");
	System.out.println("===" + ":" + serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":" + serviceInstance.getPort());
    return this.restTemplate.getForObject("http://microservice-serprovider-user-eurekaclient/simple/" + id, User.class);
  }
  
  
  @GetMapping("/test")
  public String test() {
    ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-serprovider-user-eurekaclient");
    System.out.println("111" + ":" + serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":" + serviceInstance.getPort());

    ServiceInstance serviceInstance2 = this.loadBalancerClient.choose("microservice-serprovider-user-eurekaclient2");
    System.out.println("222" + ":" + serviceInstance2.getServiceId() + ":" + serviceInstance2.getHost() + ":" + serviceInstance2.getPort());

    return "1";
  }
}