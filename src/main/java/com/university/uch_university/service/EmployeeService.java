package com.university.uch_university.service;

import com.university.uch_university.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EmployeeService extends BaseService<Employee, UUID> {
    @Autowired
    public EmployeeService(JpaRepository<Employee, UUID> repository) {
        super(repository);
    }
}
