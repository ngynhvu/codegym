package com.example.sandwich;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Sandwich {
    @GetMapping("/")
    String getIndex() {
        return "index";
    }

    @GetMapping("/save")
    public String save(@RequestParam(required = false) String vehicle1,
                       @RequestParam(required = false) String vehicle2,
                       @RequestParam(required = false) String vehicle3,
                       @RequestParam(required = false) String vehicle4, Model model) {
        String condiment;
        if(vehicle1.isEmpty()&&vehicle2.isEmpty()&&vehicle3.isEmpty()&&vehicle4.isEmpty()){
            condiment = "condiments";
        } else {
            condiment = vehicle1 + vehicle2 +vehicle3 + vehicle4;
        }
        model.addAttribute("condiment",condiment);
        return "success";
    }
}
