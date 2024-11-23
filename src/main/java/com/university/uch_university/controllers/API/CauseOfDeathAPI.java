package com.university.uch_university.controllers.API;
import com.university.uch_university.model.CauseOfDeath;
import com.university.uch_university.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/causesOfDeath")
public class CauseOfDeathAPI extends BaseAPIController<CauseOfDeath, UUID> {

    @Autowired
    protected CauseOfDeathAPI(BaseService<CauseOfDeath, UUID> baseService) {
        super(baseService);
    }
}