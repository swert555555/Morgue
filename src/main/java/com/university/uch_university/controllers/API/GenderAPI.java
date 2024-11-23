package com.university.uch_university.controllers.API;

import com.university.uch_university.model.Gender;
import com.university.uch_university.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@RestController
@RequestMapping("/api/genders")
public class GenderAPI extends BaseAPIController<Gender, UUID> {

    @Autowired
    protected GenderAPI(BaseService<Gender, UUID> baseService) {
        super(baseService);
    }
}