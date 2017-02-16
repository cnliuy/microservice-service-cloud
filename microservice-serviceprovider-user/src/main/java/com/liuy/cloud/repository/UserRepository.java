package com.liuy.cloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.liuy.cloud.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}