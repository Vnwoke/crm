package com.example.crown.crown.repository;

import com.example.crown.crown.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    //List<Guest> findByCancel(Boolean state);
   // List<Guest> findbyEnroll(Boolean state);
}
