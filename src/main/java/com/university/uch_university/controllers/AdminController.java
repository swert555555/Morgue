package com.university.uch_university.controllers;

import com.university.uch_university.model.RoleEnum;
import com.university.uch_university.model.UserModel;
import com.university.uch_university.repository.GenderRepository;
import com.university.uch_university.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
//@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
public class AdminController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GenderRepository genderRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/users")
    public String userView(Model model) {
        model.addAttribute("user_list", userRepository.findAll());
        return "indexUser";
    }

    @GetMapping("/users/{id}")
    public String detailView(@PathVariable Long id, Model model) {
        UserModel user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Пользователя не существует: " + id));
        model.addAttribute("user_object", user);
        return "info";
    }

    @PostMapping("/users/{id}/update")
    public String updateUser(@PathVariable Long id, @RequestParam String username, @RequestParam RoleEnum role){
        UserModel user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Пользователя не существует: " + id));
        user.setUsername(username);
        user.setRole(role);
        userRepository.save(user);
        return "redirect:/admin/users/"+ id;
    }

    @GetMapping("/users/{id}/update")
    public String updateView(@PathVariable Long id, Model model){
        UserModel user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Пользователя не существует: " + id));
        model.addAttribute("user_object", user);
        model.addAttribute("roles", RoleEnum.values());
        return "update";
    }
}
