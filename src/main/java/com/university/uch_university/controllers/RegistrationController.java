package com.university.uch_university.controllers;

import com.university.uch_university.model.RoleEnum;
import com.university.uch_university.model.UserModel;
import com.university.uch_university.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/registration")
    public String registrationView() {
        return "regis";
    }

    @PostMapping("/registration")
    public String registrationUser(UserModel user, Model model) {
        if (userRepository.existsByUsername(user.getUsername())) {
            model.addAttribute("message", "Пользователь уже существует!");
            return "regis";
        }
        user.setActive(true);
        user.setRole(RoleEnum.LOADER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/login";
    }
}
