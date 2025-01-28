package com.university.uch_university.service;

import com.university.uch_university.model.EmployeeHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EmployeeHistoryService extends BaseService<EmployeeHistory, UUID> {
    @Autowired
    public EmployeeHistoryService(JpaRepository<EmployeeHistory, UUID> repository) {
        super(repository);
    }
}
