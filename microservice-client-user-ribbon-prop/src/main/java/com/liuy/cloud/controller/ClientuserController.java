package com.liuy.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

  //@Value("${user.userServicePath}")
  //private String userServicePath;

  //--  http://localhost:8010/movie/1
  // in ribbon need change microservice-serprovider-user-eurekaclient
  @GetMapping("/movie/{id}")
  public User findById(@PathVariable Long id) {
    return this.restTemplate.getForObject("http://microservice-serprovider-user-eurekaclient/simple/" + id, User.class);
  }
}