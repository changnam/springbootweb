package com.honsoft.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.honsoft.web.entity.Authority;

import java.util.List;

public interface AuthoritiesRepository extends JpaRepository<Authority, Integer> {
    List<Authority> findByUsername(String username);
}
