package com.main.App.Controllers;

import com.main.App.Models.Contact;
import com.main.App.Payload.Request.ContactRequest;
import com.main.App.Payload.Response.ContactResponse;
import com.main.App.Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/contact")
@CrossOrigin
public class ContactController {
    @Autowired
    ContactService contactService;

    @GetMapping("/get")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok().body(contactService.findAll());
    }

    @GetMapping("/{id}")
    public Contact getTelephoneById(@PathVariable Long id){
        return contactService.findById(id);
    }

    @PostMapping("/post")
    public ResponseEntity<ContactResponse> add(@RequestBody ContactRequest cr){
        Contact contact = new Contact(cr.getLinkedin(), cr.getInstagram(), cr.getTelegram(), cr.getUserId());

        Contact newContact = contactService.save(contact);

        ContactResponse response = new ContactResponse(newContact.getId(), newContact.getLinkedin(), newContact.getInstagram(),
                newContact.getTelegram(), newContact.getUser().getId(), newContact.getTelephone().getId());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
