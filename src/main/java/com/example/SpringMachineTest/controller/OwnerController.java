package com.example.SpringMachineTest.controller;

import com.example.SpringMachineTest.entity.Owner;
import com.example.SpringMachineTest.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @GetMapping("/")
    public String login(Model model){
        model.addAttribute("user",new Owner());
        return "login";
    }

    @GetMapping("/adminDashboard")
    public String dashboard(Model model){
        model.addAttribute("owners",ownerService.getAllOwner());
        return "adminDashboard";
    }

    @PostMapping("/addOwner")
    public String addOwner(@ModelAttribute Owner owner){
        ownerService.addUser(owner);
        ownerService.getAllOwner();
        return "redirect:/adminDashboard";
    }

    @GetMapping("/getOwner")
    public List<Owner> getAllOwner(){
        return ownerService.getAllOwner();
    }

    @PostMapping("/toggleOwner/{id}")
    public String toggleOwner(
            @PathVariable int  id,
            @RequestParam boolean status
    ) {
        ownerService.updateOwnerStatus(id, status);
        return "redirect:/adminDashboard";
    }



}
