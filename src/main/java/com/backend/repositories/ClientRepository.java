package com.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
