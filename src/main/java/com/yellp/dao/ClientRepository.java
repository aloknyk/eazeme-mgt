package com.yellp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yellp.entity.Client;

public interface ClientRepository extends JpaRepository<Client, String> {

}
