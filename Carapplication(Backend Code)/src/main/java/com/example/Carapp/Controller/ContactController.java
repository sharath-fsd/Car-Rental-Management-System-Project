package com.example.Carapp.Controller;

import com.example.Carapp.Model.Contact;
import com.example.Carapp.Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "*")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping
    public Contact saveContact(@RequestBody Contact contact) {
        return contactService.save(contact);
    }

    @GetMapping
    public List<Contact> getAllContacts() {
        return contactService.findAll();
    }
}
