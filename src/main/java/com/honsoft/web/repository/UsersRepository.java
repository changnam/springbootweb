package com.honsoft.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.honsoft.web.entity.User;

public interface UsersRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}