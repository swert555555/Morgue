package com.university.uch_university.controllers;

import com.university.uch_university.model.Employee;
import com.university.uch_university.model.RoleEnum;
import com.university.uch_university.model.UserModel;
import com.university.uch_university.repository.EmployeeRepository;
import com.university.uch_university.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Locale;
import java.util.Optional;

@Controller
public class MainController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    public MainController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/profile")
    public String getCurrentUser(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        UserModel user = userRepository.findByUsername(username);
        model.addAttribute("user", user);
        // Поиск сотрудника по связанному пользователю
        Optional<Employee> employeeOptional = employeeRepository.findByUser(user);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            System.out.println("Employee found: " + employee.getFirstName() + " " + employee.getLastName()); // Логирование
            model.addAttribute("employee", employee);
        } else {
            System.out.println("Employee not found for user: " + user.getUsername()); // Логирование
            model.addAttribute("employee", null);
        }
        return "profile";
    }
    @Autowired
    private PasswordEncoder passwordEncoder;
    @PostMapping("/profile")
    public String updateCurrentUser(@RequestParam String username, @RequestParam String password, Model model) {
        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        UserModel user = userRepository.findByUsername(currentUsername);
        if (username != null && !username.isEmpty()) {
            user.setUsername(username);
        }
        if (password != null && !password.isEmpty()) {
            user.setPassword(passwordEncoder.encode(password));
        }
        userRepository.save(user);
        model.addAttribute("user", user);
        return "redirect:/profile";
    }
    @GetMapping("/")
    public String home(Model model, Principal principal) {
        UserModel user = userRepository.findByUsername(principal.getName());
        model.addAttribute("name", "Система для управления кадрами в структурных подразделениях организации");

        String role = user.getRole().toString().toLowerCase(Locale.ROOT);
        model.addAttribute("role", role);

        return "homePage";
    }
}
