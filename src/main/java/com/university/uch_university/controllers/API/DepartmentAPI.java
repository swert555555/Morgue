package com.university.uch_university.controllers.API;

import com.university.uch_university.model.Department;
import com.university.uch_university.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/departments")
public class DepartmentAPI extends BaseAPIController<Department, UUID> {

    @Autowired
    protected DepartmentAPI(BaseService<Department, UUID> baseService) {
        super(baseService);
    }
}