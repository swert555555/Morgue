package com.university.uch_university.controllers;

import com.university.uch_university.model.Corpse;
import com.university.uch_university.model.Gender;
import com.university.uch_university.repository.CorpseRepository;
import com.university.uch_university.repository.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/loader")
public class LoaderController {
    @Autowired
    private CorpseRepository corpseRepository;

    @Autowired
    private GenderRepository genderRepository;

    @GetMapping
    public String morgueView(Model model) {
        List<Corpse> corpses = corpseRepository.findAll();
        List<Gender> genders = genderRepository.findAll();
        model.addAttribute("corpses", corpses);
        model.addAttribute("genders", genders);
        return "loaderPage";
    }

    @PostMapping("/corpses/add")
    public String addCorpse(@ModelAttribute Corpse corpse) {
        corpseRepository.save(corpse);
        return "redirect:/loader";
    }

    @PostMapping("/corpses/{id}/edit")
    public String editCorpse(@PathVariable UUID id, @ModelAttribute Corpse corpse) {
        corpse.setId(id);
        corpse.setReceiptDate(corpseRepository.findById(id).get().getReceiptDate()); // Сохраняем текущую дату поступления
        corpseRepository.save(corpse);
        return "redirect:/loader";
    }

    @PostMapping("/corpses/{id}/delete")
    public String deleteCorpse(@PathVariable UUID id) {
        corpseRepository.deleteById(id);
        return "redirect:/loader";
    }
}