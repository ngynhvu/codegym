package com.codegym.vn;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {
    @GetMapping("/greeting")
    public String greeting() {
        return "convert/convert";
    }
    @GetMapping("/money")
    public String resultConvert(@RequestParam(required = false) int tien, @RequestParam(required = false) double option, Model model){
        double result = tien * option;
        model.addAttribute("result",result);
        return "convert/convert";
    }
}
