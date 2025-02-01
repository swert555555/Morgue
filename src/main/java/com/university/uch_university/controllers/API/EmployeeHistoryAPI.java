package com.university.uch_university.controllers.API;

import com.university.uch_university.model.EmployeeHistory;
import com.university.uch_university.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/employeesHistory")
public class EmployeeHistoryAPI extends BaseAPIController<EmployeeHistory, UUID> {

    @Autowired
    protected EmployeeHistoryAPI(BaseService<EmployeeHistory, UUID> baseService) {
        super(baseService);
    }
}
