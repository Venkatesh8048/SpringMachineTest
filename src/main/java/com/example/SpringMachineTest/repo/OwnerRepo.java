package com.example.SpringMachineTest.repo;

import com.example.SpringMachineTest.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface OwnerRepo extends JpaRepository<Owner,Integer> {

    public UserDetails findByUsername(String username);

}
