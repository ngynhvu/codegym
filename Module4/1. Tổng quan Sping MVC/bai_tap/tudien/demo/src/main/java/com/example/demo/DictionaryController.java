package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    private static String[] vietnamese = {"sach", "ban", "ca"};
    private static String[] english1 = {"book", "table", "fish"};
    @PostMapping("/dictionary")
    public String dictionary(@RequestParam(required = false) String english, Model model){
        if(english.isEmpty()){
            model.addAttribute("mess", "Not Null");
        }else {
            for(int i = 0; i<vietnamese.length;i++){
                if(english1[i].equals(english)){
                    model.addAttribute("result", vietnamese[i]);
                }
            }
        }
        return "index";
    }
    @GetMapping("/")
    String getIndex()
    {return "index";}
}
