package com.javalec.spring.TheHuddleSite.repository;

import com.javalec.spring.TheHuddleSite.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
