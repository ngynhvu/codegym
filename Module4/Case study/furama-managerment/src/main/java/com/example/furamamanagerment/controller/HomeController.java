package com.example.furamamanagerment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @GetMapping("/demo")
    public ModelAndView showHomePage(){
        ModelAndView modelAndView = new ModelAndView("/demo/list");
        return modelAndView;
    }
}
