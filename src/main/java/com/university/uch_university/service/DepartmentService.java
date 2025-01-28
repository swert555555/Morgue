package com.university.uch_university.service;

import com.university.uch_university.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DepartmentService extends BaseService<Department, UUID> {
    @Autowired
    public DepartmentService(JpaRepository<Department, UUID> repository) {
        super(repository);
    }
}
