package com.university.uch_university.controllers.API;

import com.university.uch_university.model.Autopsy;
import com.university.uch_university.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/autopsies")
public class AutopsyAPI extends BaseAPIController<Autopsy, UUID> {

    @Autowired
    protected AutopsyAPI(BaseService<Autopsy, UUID> baseService) {
        super(baseService);
    }
}