package com.example.crown.crown.controller;

import com.example.crown.crown.dto.NewContactDto;
import com.example.crown.crown.models.Client;
import com.example.crown.crown.models.Contact;
import com.example.crown.crown.repository.ClientRepository;
import com.example.crown.crown.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ContactRepository contactRepository;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/guest/contact")
    public String guestContact(Model model) {
        NewContactDto contactDto = new NewContactDto();
        model.addAttribute("contactDto", contactDto);
        List<Client> clients = clientRepository.findAll();
        model.addAttribute("clients", clients);
        return "guest_contact";
    }

    @PostMapping("/guest/contact")
    public String postGuestContact(@ModelAttribute NewContactDto contactDto, Model model) {
        //model.addAttribute("contactDto", contactDto)
        Optional<Client> optional = clientRepository.findById(contactDto.getClientId());
        Client client = optional.get();
        Contact contact = new Contact();
        contact.setGuest(contactDto.getGuest());
        contact.setContactdate(new Date());
        contactRepository.save(contact);
        contactRepository.flush();
        model.addAttribute("contact", contact);
        return "contact_no";
    }

    @GetMapping("/login")
    public String login() { return "login";}

    @GetMapping("/dashboard")
    public String dashboard(){return "dashboard";}
}
