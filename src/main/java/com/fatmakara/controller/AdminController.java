package com.fatmakara.controller;


import com.fatmakara.entities.Admin;
import com.fatmakara.repository.AdminRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

    private final AdminRepository adminRepository;

    public AdminController(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @PostMapping("/login")
    public boolean login(@RequestBody Admin loginData) {
        return adminRepository.findByEmailAndPassword(loginData.getEmail(),loginData.getPassword()).isPresent();
    }
}