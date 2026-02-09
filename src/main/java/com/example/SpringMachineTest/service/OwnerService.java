package com.example.SpringMachineTest.service;

import com.example.SpringMachineTest.entity.Owner;
import com.example.SpringMachineTest.entity.Role;
import com.example.SpringMachineTest.repo.OwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepo ownerRepo;

    @Autowired
    private MailService mailService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void addUser(Owner owner){
        String rawPassword = owner.getPassword();
        owner.setPassword(bCryptPasswordEncoder.encode(owner.getPassword()));
        owner.setRole(Role.ROLE_OWNER);
        owner.setEnabled(true);
        ownerRepo.save(owner);

        mailService.sendMail(
                owner.getEmail(),
                "Owner Registration",
                "Hello " + owner.getUsername() + ",\n\n" +
                        "You have been successfully added to the system.\n\n" +
                        "Username: " + owner.getUsername() + "\n" +
                        "Password: " + rawPassword
        );
    }

    public List<Owner> getAllOwner(){
        return ownerRepo.findAll();
    }

    public void updateOwnerStatus(int id,boolean status){
        Owner owner = ownerRepo.findById(id).orElseThrow();
        owner.setEnabled(status);
        ownerRepo.save(owner);
    }
}
