package com.example.validateuser.controller;

import com.example.validateuser.model.User;
import com.example.validateuser.service.UserService;
import com.example.validateuser.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserService service;

    @Autowired
    private UserValidator validator;

    @GetMapping("/create")
    public String displayCreate(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }
    @PostMapping("create")
    public String create(@Validated @ModelAttribute("user") User user, BindingResult bindingResult) {
        validator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "index";
        }
        service.save(user);
        return "result";
    }
}
