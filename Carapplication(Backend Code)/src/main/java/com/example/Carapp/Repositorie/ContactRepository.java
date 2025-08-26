package com.example.Carapp.Repositorie;

import com.example.Carapp.Model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
