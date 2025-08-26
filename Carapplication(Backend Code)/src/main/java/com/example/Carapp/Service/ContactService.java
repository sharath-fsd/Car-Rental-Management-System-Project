package com.example.Carapp.Service;

import com.example.Carapp.Model.Contact;
import java.util.List;

public interface ContactService {
    Contact save(Contact contact);
    List<Contact> findAll();
}
