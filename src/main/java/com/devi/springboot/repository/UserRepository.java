package com.devi.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devi.springboot.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	
}
