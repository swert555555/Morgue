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

import java.util.UUID;

@Controller
@RequestMapping("/admin")
//@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    @Autowired
    private PositionRepository positionRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private ChangeTypeRepository changeTypeRepository;
    @Autowired
    private CityRepository cityRepository;

    // Управление департаментами
    @GetMapping("/departments")
    public String getAllDepartments(Model model) {
        model.addAttribute("departments", departmentRepository.findAll());
        model.addAttribute("department", new Department());
        model.addAttribute("cities", cityRepository.findAll());
        return "admin/departments";
    }
    @PostMapping("/departments/add")
    public String addDepartment(@Valid @ModelAttribute Department department, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("departments", departmentRepository.findAll());
            model.addAttribute("cities", cityRepository.findAll());
            return "admin/departments";
        }
        // Если родительский департамент указан, убедимся, что он существует
        if (department.getParentDepartment() != null && department.getParentDepartment().getId() != null) {
            Department parent = departmentRepository.findById(department.getParentDepartment().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Родительский департамент не найден"));
            department.setParentDepartment(parent);
        } else {
            // Если родительский департамент не указан, устанавливаем его в null
            department.setParentDepartment(null);
        }

        departmentRepository.save(department);
        return "redirect:/admin/departments";
    }
    @PostMapping("/departments/{id}/edit")
    public String editDepartment(@PathVariable UUID id, @ModelAttribute Department department) {
        Department existingDepartment = departmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Департамент не найден"));

        // Обновляем поля
        existingDepartment.setName(department.getName());
        existingDepartment.setCity(department.getCity());

        // Обрабатываем родительский департамент
        if (department.getParentDepartment() != null && department.getParentDepartment().getId() != null) {
            Department parent = departmentRepository.findById(department.getParentDepartment().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Родительский департамент не найден"));
            existingDepartment.setParentDepartment(parent);
        } else {
            existingDepartment.setParentDepartment(null);
        }
        departmentRepository.save(existingDepartment);
        return "redirect:/admin/departments";
    }
    @PostMapping("/departments/{id}/delete")
    public String deleteDepartment(@PathVariable UUID id) {
        departmentRepository.deleteById(id);
        return "redirect:/admin/departments";
    }

    // Управление должностями
    @GetMapping("/positions")
    public String getAllPositions(Model model) {
        model.addAttribute("positions", positionRepository.findAll());
        model.addAttribute("position", new Position());
        return "admin/positions";
    }
    @PostMapping("/positions/add")
    public String addPosition(@Valid @ModelAttribute Position position, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/positions";
        }
        positionRepository.save(position);
        return "redirect:/admin/positions";
    }
    @PostMapping("/positions/{id}/edit")
    public String editPosition(@PathVariable UUID id, @ModelAttribute Position position) {
        position.setId(id);
        positionRepository.save(position);
        return "redirect:/admin/positions";
    }
    @PostMapping("/positions/{id}/delete")
    public String deletePosition(@PathVariable UUID id) {
        positionRepository.deleteById(id);
        return "redirect:/admin/positions";
    }

    // Управление городами
    @GetMapping("/cities")
    public String getAllCities(Model model) {
        model.addAttribute("cities", cityRepository.findAll());
        model.addAttribute("city", new City());
        return "admin/cities";
    }
    @PostMapping("/cities/add")
    public String addCity(@Valid @ModelAttribute City city, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/cities";
        }
        cityRepository.save(city);
        return "redirect:/admin/cities";
    }
    @PostMapping("/cities/{id}/edit")
    public String editCity(@PathVariable UUID id, @ModelAttribute City city) {
        city.setId(id);
        cityRepository.save(city);
        return "redirect:/admin/cities";
    }
    @PostMapping("/cities/{id}/delete")
    public String deleteCity(@PathVariable UUID id) {
        cityRepository.deleteById(id);
        return "redirect:/admin/cities";
    }

    // Управление типами изменений
    @GetMapping("/changeTypes")
    public String getAllChangeTypes(Model model) {
        model.addAttribute("changeTypes", changeTypeRepository.findAll());
        model.addAttribute("changeType", new ChangeType());
        return "admin/changeTypes";
    }
    @PostMapping("/changeTypes/add")
    public String addChangeType(@ModelAttribute ChangeType changeType) {
        changeTypeRepository.save(changeType);
        return "redirect:/admin/changeTypes";
    }
    @PostMapping("/changeTypes/{id}/edit")
    public String editChangeType(@PathVariable UUID id, @ModelAttribute ChangeType changeType) {
        changeType.setId(id);
        changeTypeRepository.save(changeType);
        return "redirect:/admin/changeTypes";
    }
    @PostMapping("/changeTypes/{id}/delete")
    public String deleteChangeType(@PathVariable UUID id) {
        changeTypeRepository.deleteById(id);
        return "redirect:/admin/changeTypes";
    }
}