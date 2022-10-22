package com.example.caculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculatorController {
    @PostMapping("/calculator")
    public String getTimeByTimezone(ModelMap model, @RequestParam(required = false) int value1,@RequestParam(required = false) int value2, @RequestParam(name = "phep_tinh", required = false, defaultValue = "cong") String pheptinh) {
        int result = 0;
        switch (pheptinh){
            case "cong":
                result = value1 + value2;
                break;
            case "tru":
                result = value1 - value2;
                break;
            case "nhan":
                result = value1*value2;
                break;
            case "chia":
                if(value2 == 0){
                    model.addAttribute("mess", "Value 2 khac 0");
                }else {
                    result = value1/value2;
                }
                break;
        }
        model.addAttribute("result", result);
        return "index";
    }

    @GetMapping
    String getIndex(){return "index";}

}
