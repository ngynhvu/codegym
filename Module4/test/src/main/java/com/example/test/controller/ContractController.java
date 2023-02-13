//package com.example.test.controller;
//
//import com.example.test.service.contract.ContractService;
//import com.example.test.service.customer.CustomerService;
//import com.example.test.validator.ContractValidator;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.text.ParseException;
//import java.util.Optional;
//
//@Controller
//public class ContractController {
//    @Autowired
//    private CustomerService customerService;
//    @Autowired
//    private ContractService contractService;
//
//    @Autowired
//    private ContractValidator validator;
//
//
//    @GetMapping("/create-contract")
//    public ModelAndView showCreateForm() {
//        ModelAndView modelAndView = new ModelAndView("/contract/create");
//        modelAndView.addObject("contract", new Contract());
//        modelAndView.addObject("customers", customerService.findAll());
//        return modelAndView;
//    }
//
//    @PostMapping("/create-contract")
//    public ModelAndView saveCustomer(@Validated  @ModelAttribute("contract") Contract contract, BindingResult bindingResult) throws ParseException {
//        ModelAndView modelAndView = new ModelAndView("/contract/create");
//        validator.validate(contract, bindingResult);
//        if (bindingResult.hasErrors()) {
//            modelAndView.addObject("customers", customerService.findAll());
//            return modelAndView;
//        }
//        contractService.save(contract);
//        modelAndView.addObject("message", "New contract created successfully");
//        return modelAndView;
//    }
//
//    @GetMapping("/contracts")
//    public ModelAndView listContract() {
//        ModelAndView modelAndView = new ModelAndView("/contract/list");
//        modelAndView.addObject("contracts", contractService.findAll());
//        return modelAndView;
//    }
//
//    @GetMapping("/detail-contract/{id}")
//    public ModelAndView showDetail(@PathVariable Long id) {
//        Optional<Contract> contract = contractService.findById(id);
//        if (contract.isPresent()) {
//            ModelAndView modelAndView = new ModelAndView("/contract/detail");
//            modelAndView.addObject("contract", contract.get());
//            return modelAndView;
//        } else {
//            ModelAndView modelAndView = new ModelAndView("/contract/list");
//            modelAndView.addObject("message", "Not found");
//            return modelAndView;
//        }
//    }
//
//    @GetMapping("/delete-customer/{id}")
//    public ModelAndView showDeleteForm(@PathVariable Long id) {
//        Optional<Contract> contract = contractService.findById(id);
//        if (contract.isPresent()) {
//            ModelAndView modelAndView = new ModelAndView("/contract/detail");
//            modelAndView.addObject("contract", contract.get());
//            return modelAndView;
//
//        } else {
//            ModelAndView modelAndView = new ModelAndView("/contract/detail");
//            modelAndView.addObject("message", "Not found");
//            return modelAndView;
//        }
//    }
//
//    @PostMapping("/delete-contract")
//    public String deleteCustomer(@ModelAttribute("contract") Contract contract) {
//        contractService.remove(contract.getId());
//        return "redirect:contracts";
//    }
//
//    @GetMapping("/search")
//    public ModelAndView listContracts(@RequestParam("kq") String kq){
//        ModelAndView modelAndView = new ModelAndView("/contract/list");
//        modelAndView.addObject("contracts", contractService.searchContract(kq));
//        return modelAndView;
//    }
//
//    @GetMapping("/search2")
//    public ModelAndView search2(@RequestParam(required = false) String searchVal){
//        return new ModelAndView("contract/list", "contracts", contractService.search(searchVal));
//    }
//}
