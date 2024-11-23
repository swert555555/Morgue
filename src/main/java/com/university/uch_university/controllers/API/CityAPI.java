package com.university.uch_university.controllers.API;

import com.university.uch_university.model.City;
import com.university.uch_university.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

@RestController
@RequestMapping("/api/cities")
public class CityAPI extends BaseAPIController<City, UUID> {

    @Autowired
    protected CityAPI(BaseService<City, UUID> baseService) {
        super(baseService);
    }
}
