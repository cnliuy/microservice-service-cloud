package com.liuy.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.liuy.cloud.entity.User;
import com.liuy.cloud.repository.UserRepository;
import com.netflix.appinfo.InstanceInfo;

import com.netflix.discovery.EurekaClient;
import org.springframework.cloud.client.discovery.DiscoveryClient;

@RestController
public class UserController {

  @Autowired
  private UserRepository userRepository;

  // 127.0.0.1:7900/simple/1
  @GetMapping("/simple/{id}")
  public User findById(@PathVariable Long id) {
    return this.userRepository.findOne(id);
  }
  
  
  
  // use  erueka client
  @Autowired
  private EurekaClient eurekaClient;

  @GetMapping("/erueka-instance")
  public String serviceUrl() {
      //InstanceInfo instance = discoveryClient.getNextServerFromEureka("STORES", false);
      InstanceInfo instance = eurekaClient.getNextServerFromEureka("MICROSERVICE-SERPROVIDER-USER-EUREKACLIENT", false);
      return instance.getHomePageUrl();
  }
  
  @Autowired
  private DiscoveryClient discoveryClient;
  
  
  @GetMapping("/instance-info")
  public ServiceInstance showInfo() {
    ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
    return localServiceInstance;
  }
  
}