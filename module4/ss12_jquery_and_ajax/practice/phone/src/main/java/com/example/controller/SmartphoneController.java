package com.example.controller;

import com.example.model.Smartphone;
import com.example.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/smartphone")
public class SmartphoneController {
    @Autowired
    private ISmartphoneService iSmartphoneService;

    @RequestMapping("")
    public String list(Model model, @PageableDefault(value = 4) Pageable pageable) {
        Page<Smartphone> smartphonePage = iSmartphoneService.findAll(pageable);
        model.addAttribute("smartphonePage", smartphonePage);
        return "list";
    }
    @PostMapping
    public ResponseEntity<Smartphone>create(@RequestBody Smartphone smartphone){
        return new ResponseEntity<>(iSmartphoneService.save(smartphone),HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<Iterable<Smartphone>> allPhones() {
        return new ResponseEntity<>(iSmartphoneService.findAll(Pageable.unpaged()), HttpStatus.OK);
    }

}
