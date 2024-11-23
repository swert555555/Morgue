package com.university.uch_university.controllers.API;

import com.university.uch_university.model.Corpse;
import com.university.uch_university.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/corpses")
public class CorpseAPI extends BaseAPIController<Corpse, UUID> {

    @Autowired
    protected CorpseAPI(BaseService<Corpse, UUID> baseService) {
        super(baseService);
    }
}