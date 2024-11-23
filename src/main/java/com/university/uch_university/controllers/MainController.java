package com.university.uch_university.controllers;

import com.university.uch_university.model.RoleEnum;
import com.university.uch_university.model.UserModel;
import com.university.uch_university.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Locale;

@Controller
public class MainController {

    private final UserRepository userRepository;

    public MainController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String home(Model model, Principal principal) {
        UserModel user = userRepository.findByUsername(principal.getName());
        model.addAttribute("name", "Суита проджект");

        String role = user.getRole().toString().toLowerCase(Locale.ROOT);
        model.addAttribute("role", role);

        return "homePage";
    }
}
