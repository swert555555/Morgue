package com.university.uch_university.controllers.API;

import com.university.uch_university.model.Employee;
import com.university.uch_university.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/employees")
public class EmployeeAPI extends BaseAPIController<Employee, UUID> {

    @Autowired
    protected EmployeeAPI(BaseService<Employee, UUID> baseService) {
        super(baseService);
    }
}