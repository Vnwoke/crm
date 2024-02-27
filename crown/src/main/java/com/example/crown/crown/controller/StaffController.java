package com.example.crown.crown.controller;

import com.example.crown.crown.dto.ContactedContactDto;
import com.example.crown.crown.models.Contact;
import com.example.crown.crown.models.User;
import com.example.crown.crown.repository.ContactRepository;
import com.example.crown.crown.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class StaffController {
    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/staff/dashboard")
    public String staff_dashboard() {
        return "staff_dashboard";
    }

    @GetMapping("/staff/contacts")
    public String staff_contacts(Model model){
        List<Contact> contacts = contactRepository.findByContacted(false);
        model.addAttribute("contacts", contacts);
        ContactedContactDto contactDto = new ContactedContactDto();
        model.addAttribute("contactDto", contactDto);
        return "staff_contacts";
    }

    @PostMapping("/staff/contacted/contact")
    public String staffContactedC0ontact(@ModelAttribute ContactedContactDto contactDto, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUsername(auth.getName());
        Optional<Contact> optional = contactRepository.findById(contactDto.getContactId());
        if(optional.isPresent()) {
            Contact contact = optional.get();
            contact.setContacted(true);
            contact.setStaff(user);
            contactRepository.save(contact);
            return "redirect:/staff/contacts";
        }
        else {
            model.addAttribute("error_msg", "Id" + contactDto.getContactId() + " not found");
            return "error";
        }
    }
}
