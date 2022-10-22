package com.example.tudien;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/dictionary")
public class Dictionary {
    private static String dictionary;
    public String word(@RequestParam String word, Model model){
        return word;
    }
}
