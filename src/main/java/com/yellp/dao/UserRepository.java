package com.yellp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yellp.entity.ApplicationUser;

public interface UserRepository extends JpaRepository<ApplicationUser, String> {

	ApplicationUser findByUsername(String username);

}
