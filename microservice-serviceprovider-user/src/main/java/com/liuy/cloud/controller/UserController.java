package com.liuy.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.liuy.cloud.entity.User;
import com.liuy.cloud.repository.UserRepository;

@RestController
public class UserController {

  @Autowired
  private UserRepository userRepository;

  // 127.0.0.1:7900/simple/1
  @GetMapping("/simple/{id}")
  public User findById(@PathVariable Long id) {
    return this.userRepository.findOne(id);
  }
}