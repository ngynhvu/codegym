package com.example.springsecurity.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecurityController {
    @GetMapping("/welcome")
    public ModelAndView showWelcome(){
        ModelAndView modelAndView = new ModelAndView("/welcome");
        return modelAndView;
    }

    @GetMapping("profile")
    public ModelAndView showProfile(){
        ModelAndView modelAndView = new ModelAndView("/profile");
        return modelAndView;
    }
}

