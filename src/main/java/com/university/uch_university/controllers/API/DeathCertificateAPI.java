package com.university.uch_university.controllers.API;

import com.university.uch_university.model.DeathCertificate;
import com.university.uch_university.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/deathCertificates")
public class DeathCertificateAPI extends BaseAPIController<DeathCertificate, UUID> {

    @Autowired
    protected DeathCertificateAPI(BaseService<DeathCertificate, UUID> baseService) {
        super(baseService);
    }
}