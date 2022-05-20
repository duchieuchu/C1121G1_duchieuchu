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

@CrossOrigin("*")
@RestController
@RequestMapping("/smartphone")
public class SmartphoneController {
    @Autowired
    private ISmartphoneService iSmartphoneService;

    @RequestMapping("")
    public String list(Model model, @PageableDefault(value = 10) Pageable pageable) {
        Page<Smartphone> smartphonePage = iSmartphoneService.findAll(pageable);
        model.addAttribute("smartphonePage", smartphonePage);
        return "list";
    }

    @RequestMapping("/list")
    public ResponseEntity<Page<Smartphone>> list1(Model model, @PageableDefault(value = 10) Pageable pageable) {
        Page<Smartphone> smartphonePage = iSmartphoneService.findAll(pageable);
        model.addAttribute("smartphonePage", smartphonePage);
        return new ResponseEntity<>(smartphonePage, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Smartphone> create(@RequestBody Smartphone smartphone) {
        return new ResponseEntity<>(iSmartphoneService.save(smartphone), HttpStatus.CREATED);
    }

    //show list web
    @GetMapping
    public ResponseEntity<Iterable<Smartphone>> allPhones() {
        return new ResponseEntity<>(iSmartphoneService.findAll(Pageable.unpaged()), HttpStatus.OK);
    }

    //delete day ne
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Smartphone> deleteSmartphone(@PathVariable Long id) {
        Smartphone smartphone = iSmartphoneService.findById(id);
        iSmartphoneService.remove(smartphone);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/edit/{id}")
    public ResponseEntity<Smartphone>showEdit(@PathVariable Long id){
        return new ResponseEntity<>(this.iSmartphoneService.findById(id),HttpStatus.OK);
    }
    @PatchMapping("/edit")
    public ResponseEntity<Smartphone>edit(@RequestBody Smartphone smartphone){
        iSmartphoneService.save(smartphone);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
