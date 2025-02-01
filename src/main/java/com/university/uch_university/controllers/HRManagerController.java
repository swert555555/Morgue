package com.university.uch_university.controllers;

import com.university.uch_university.model.*;
import com.university.uch_university.repository.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/hr")
//@PreAuthorize("hasRole('HR_MANAGER')")
public class HRManagerController {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ChangeTypeRepository changeTypeRepository;
    @Autowired
    private PositionRepository positionRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private EmployeeHistoryRepository employeeHistoryRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/employees")
    public String getAllEmployee(Model model) {
        model.addAttribute("employees", employeeRepository.findAll());
        model.addAttribute("positions", positionRepository.findAll());
        model.addAttribute("departments", departmentRepository.findAll());
        model.addAttribute("employee", new Employee());
        model.addAttribute("employeeHistory", employeeHistoryRepository.findAll());
        model.addAttribute("changeTypes", changeTypeRepository.findAll());
        model.addAttribute("users", userRepository.findAll());

        return "hr/employees";
    }
    @PostMapping("/employees/add")
    public String addEmployee(@ModelAttribute Employee employee, Model model) {
        employee.setHireDate(LocalDateTime.now());
        employeeRepository.save(employee);

        ChangeType hireChangeType = changeTypeRepository.findByName("Найм");
        if (hireChangeType == null) {
            throw new RuntimeException("Тип изменения 'Найм' не найден");
        }
        EmployeeHistory history = new EmployeeHistory();
        history.setEmployee(employee);
        history.setChangeType(hireChangeType);
        history.setChangeDate(LocalDateTime.now());
        employeeHistoryRepository.save(history);
        return "redirect:/hr/employees";
    }
    @PostMapping("/employees/{id}/edit")
    public String editEmployee(@PathVariable UUID id, @ModelAttribute Employee employee,
                               @RequestParam UUID changeTypeId,
                               @RequestParam(required = false) UUID userId) {
        try {
            // Устанавливаем ID сотрудника
            employee.setId(id);
            // Устанавливаем дату найма
            employee.setHireDate(LocalDateTime.now());
            // Устанавливаем пользователя, если userId предоставлен
            if (userId != null) {
                UserModel user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
                employee.setUser(user);
            } else {
                employee.setUser(null);
            }
            // Сохраняем сотрудника
            employeeRepository.save(employee);
            // Создаем и сохраняем историю изменений
            EmployeeHistory history = new EmployeeHistory();
            history.setEmployee(employee);
            history.setChangeType(changeTypeRepository.findById(changeTypeId).orElseThrow(() -> new RuntimeException("Change type not found")));
            history.setChangeDate(LocalDateTime.now());
            employeeHistoryRepository.save(history);

            return "redirect:/hr/employees";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/hr/employees?error=true";
        }
    }

    @PostMapping("/employees/{id}/delete")
    public String deleteEmployee(@PathVariable UUID id) {
        employeeRepository.deleteById(id);
        return "redirect:/hr/employees";
    }
}