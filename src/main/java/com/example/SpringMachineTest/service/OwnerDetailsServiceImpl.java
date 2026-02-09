package com.example.SpringMachineTest.service;

import com.example.SpringMachineTest.repo.OwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class OwnerDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private OwnerRepo ownerRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return ownerRepo.findByUsername(username);
    }
}
