package com.university.uch_university.controllers.API;

import com.university.uch_university.model.*;
import com.university.uch_university.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/changeTypes")
public class ChangeTypeAPI extends BaseAPIController<ChangeType, UUID> {

    @Autowired
    protected ChangeTypeAPI(BaseService<ChangeType, UUID> baseService) {
        super(baseService);
    }
}




