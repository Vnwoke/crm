package com.example.crown.crown.repository;

import com.example.crown.crown.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository  extends JpaRepository<Contact, Long> {
    List<Contact> findByContacted(Boolean state);



}
