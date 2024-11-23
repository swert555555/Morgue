package com.university.uch_university.controllers;

import com.university.uch_university.model.*;
import com.university.uch_university.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/pathologist")
public class PathologistController {
    @Autowired
    private CorpseRepository corpseRepository;

    @Autowired
    private CauseOfDeathRepository causeOfDeathRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DeathCertificateRepository deathCertificateRepository;

    @Autowired
    private AutopsyRepository autopsyRepository;

    @Autowired
    private GenderRepository genderRepository;

    @GetMapping
    public String pathologistView(Model model) {
        List<Corpse> corpses = corpseRepository.findAll();
        List<CauseOfDeath> causesOfDeath = causeOfDeathRepository.findAll();
        List<DeathCertificate> deathCertificates = deathCertificateRepository.findAll();
        List<Autopsy> autopsies = autopsyRepository.findAll();
        List<Gender> genders = genderRepository.findAll();

        model.addAttribute("corpses", corpses);
        model.addAttribute("causesOfDeath", causesOfDeath);
        model.addAttribute("deathCertificates", deathCertificates);
        model.addAttribute("autopsies", autopsies);
        model.addAttribute("genders", genders);

        return "pathologistPage";
    }
/*
    @PostMapping("/corpses/add")
    public String addCorpse(@ModelAttribute Corpse corpse) {
        corpse.setReceiptDate(LocalDateTime.now());
        corpseRepository.save(corpse);
        return "redirect:/pathologist";
    }*/

    @PostMapping("/corpses/{id}/edit")
    public String editCorpse(@PathVariable UUID id, @ModelAttribute Corpse corpse) {
        corpse.setId(id);
        corpse.setReceiptDate(corpseRepository.findById(id).get().getReceiptDate());
        corpseRepository.save(corpse);
        return "redirect:/pathologist";
    }

    @PostMapping("/corpses/{id}/delete")
    public String deleteCorpse(@PathVariable UUID id) {
        corpseRepository.deleteById(id);
        return "redirect:/pathologist";
    }

    @PostMapping("/causesOfDeath/add")
    public String addCauseOfDeath(@ModelAttribute CauseOfDeath causeOfDeath) {
        causeOfDeathRepository.save(causeOfDeath);
        return "redirect:/pathologist";
    }

    @PostMapping("/causesOfDeath/{id}/edit")
    public String editCauseOfDeath(@PathVariable UUID id, @ModelAttribute CauseOfDeath causeOfDeath) {
        causeOfDeath.setId(id);
        causeOfDeathRepository.save(causeOfDeath);
        return "redirect:/pathologist";
    }

    @PostMapping("/causesOfDeath/{id}/delete")
    public String deleteCauseOfDeath(@PathVariable UUID id) {
        causeOfDeathRepository.deleteById(id);
        return "redirect:/pathologist";
    }

    @PostMapping("/deathCertificates/add")
    public String addDeathCertificate(@ModelAttribute DeathCertificate deathCertificate) {
        deathCertificateRepository.save(deathCertificate);
        return "redirect:/pathologist";
    }

    @PostMapping("/deathCertificates/{id}/edit")
    public String editDeathCertificate(@PathVariable UUID id, @ModelAttribute DeathCertificate deathCertificate) {
        deathCertificate.setId(id);
        deathCertificateRepository.save(deathCertificate);
        return "redirect:/pathologist";
    }

    @PostMapping("/deathCertificates/{id}/delete")
    public String deleteDeathCertificate(@PathVariable UUID id) {
        deathCertificateRepository.deleteById(id);
        return "redirect:/pathologist";
    }

    @PostMapping("/autopsies/add")
    public String addAutopsy(@ModelAttribute Autopsy autopsy) {
        autopsy.setPerformedBy(getCurrentUser());
        autopsyRepository.save(autopsy);
        return "redirect:/pathologist";
    }

    @PostMapping("/autopsies/{id}/edit")
    public String editAutopsy(@PathVariable UUID id, @ModelAttribute Autopsy autopsy) {
        autopsy.setId(id);
        autopsy.setPerformedBy(getCurrentUser());
        autopsyRepository.save(autopsy);
        return "redirect:/pathologist";
    }

    @PostMapping("/autopsies/{id}/delete")
    public String deleteAutopsy(@PathVariable UUID id) {
        autopsyRepository.deleteById(id);
        return "redirect:/pathologist";
    }

    private UserModel getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        return userRepository.findByUsername(currentUserName);
    }
}