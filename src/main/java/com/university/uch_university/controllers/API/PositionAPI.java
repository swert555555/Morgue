package com.university.uch_university.controllers.API;

import com.university.uch_university.model.Position;
import com.university.uch_university.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/positions")
public class PositionAPI extends BaseAPIController<Position, UUID> {

    @Autowired
    protected PositionAPI(BaseService<Position, UUID> baseService) {
        super(baseService);
    }
}