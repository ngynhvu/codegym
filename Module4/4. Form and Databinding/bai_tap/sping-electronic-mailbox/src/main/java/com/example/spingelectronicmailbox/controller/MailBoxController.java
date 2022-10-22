package com.example.spingelectronicmailbox.controller;

import com.example.spingelectronicmailbox.model.MailBox;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MailBoxController {
    @GetMapping("/home")
    public String showForm(Model model){
        List<String> languageList = new ArrayList<>();
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Japanese");
        languageList.add("Chinese");

        List<Integer> pageList = new ArrayList<>();
        pageList.add(5);
        pageList.add(10);
        pageList.add(15);
        pageList.add(25);
        pageList.add(50);
        pageList.add(100);
        model.addAttribute("languageList",languageList);
        model.addAttribute("pageList",pageList);
        model.addAttribute("mail",new MailBox());
        return "home";
    }

    @PostMapping("/update")
    public String updateMail(@ModelAttribute MailBox mailBox, RedirectAttributes redirectAttributes,Model model){
        model.addAttribute("mailBox",mailBox);
        redirectAttributes.addFlashAttribute("messages", "Update successfully");
        return "mail";
    }
}
