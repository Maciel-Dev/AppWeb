package com.main.App.Service;

import com.main.App.Models.Contact;
import com.main.App.Repositories.ContactRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ContactService {
    @Autowired
    private ContactRepository cr;

    public Contact save(Contact contact){
        return cr.save(contact);
    }

    public List<Contact> findAll(){
        return cr.findAll();
    }

    public Contact findById(Long id) {
        return cr.findById(id).orElseThrow(() -> new RuntimeException("Contact not found!"));
    }

    public void delete(Long id){
        cr.deleteById(id);
    }
}
