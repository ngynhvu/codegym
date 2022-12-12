package com.example.demo.controller.rest;


import com.example.demo.model.Customer;
import com.example.demo.service.ICustomerService;
import com.example.demo.service.ICustomerServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
public class CustomerAPIController {
    @Autowired
    private ICustomerServiceAPI customerService;

    @PostMapping
    public ResponseEntity<Customer> createSmartphone(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.save(customer), HttpStatus.CREATED);
    }
    @GetMapping("/list")
    public ModelAndView getAllSmartphonePage() {
        ModelAndView modelAndView = new ModelAndView("/customer/list_ajax");
        modelAndView.addObject("customers", customerService.findAll());
        return modelAndView;
    }
    @GetMapping
    public ResponseEntity<Iterable<Customer>> allPhones() {
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> deleteSmartphone(@PathVariable Long id) {
        Optional<Customer> smartphoneOptional = customerService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customerService.remove(id);
        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.NO_CONTENT);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Customer> getSmartPhone(@PathVariable long id) {
        return new ResponseEntity<>(customerService.findById(id).get(), HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Customer> updateSmartphone(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.save(customer), HttpStatus.CREATED);
    }
    @PostMapping("/search")
    public ResponseEntity<Iterable<Customer>> listBlog(@RequestBody String searchValue){
        return new ResponseEntity<>(customerService.findFirstName(searchValue),HttpStatus.OK);
    }
}
