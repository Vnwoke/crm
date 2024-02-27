package com.example.crown.crown.controller;


import com.example.crown.crown.models.Client;
import com.example.crown.crown.models.User;
import com.example.crown.crown.repository.ClientRepository;
import com.example.crown.crown.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ManagerController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClientRepository clientRepository;


    @GetMapping("/manager/dashboard")
    public  String manager_dashboard(){
        return "manager_dashboard";
    }

    @GetMapping("/manager/contacts/by/staff")
    private String contacts_by_staff(Model model) {
        List<User> staff = userRepository.findAllByRole("ROLE_STAFF");
        model.addAttribute("staff", staff);
        return "contacts_by_staff";
    }

    @GetMapping("/manager/clients")
    private String clients(Model model) {
        List<Client> clients = clientRepository.findAll();
        model.addAttribute("clients", clients);

        return "manager_clients";
    }
}
