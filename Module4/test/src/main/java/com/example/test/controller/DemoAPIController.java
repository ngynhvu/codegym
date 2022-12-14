package com.example.test.controller;

import com.example.test.model.Demo;
import com.example.test.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;
@RestController
@RequestMapping("/api/demo")
public class DemoAPIController {
    @Autowired
    private DemoService service;

    @PostMapping
    public ResponseEntity<Demo> createSmartphone(@RequestBody Demo demo) {
        return new ResponseEntity<>(service.save(demo), HttpStatus.CREATED);
    }
//    @GetMapping("/list")
//    public ModelAndView getAllSmartphonePage() {
//        ModelAndView modelAndView = new ModelAndView("/demo/list");
//        modelAndView.addObject("demos", service.findAll());
//        return modelAndView;
//    }

    @GetMapping("/list")
    public ModelAndView getAllSmartphonePage(@PageableDefault(value = 3)Pageable pageable) {
        Page<Demo> demos = service.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/demo/list");
        modelAndView.addObject("demos", demos);
        return modelAndView;
    }
    @GetMapping
    public ResponseEntity<Iterable<Demo>> allPhones() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Demo> deleteSmartphone(@PathVariable Long id) {
        Optional<Demo> smartphoneOptional = service.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.remove(id);
        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.NO_CONTENT);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Demo> getSmartPhone(@PathVariable long id) {
        return new ResponseEntity<>(service.findById(id).get(), HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Demo> updateSmartphone(@RequestBody Demo demo) {
        return new ResponseEntity<>(service.save(demo), HttpStatus.CREATED);
    }
}
