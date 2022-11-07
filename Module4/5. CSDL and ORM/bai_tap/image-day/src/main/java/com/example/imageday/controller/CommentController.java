package com.example.imageday.controller;


import com.example.imageday.model.Comment;
import com.example.imageday.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommentController {

    @Autowired
    private ICommentService service;

    @GetMapping("/create")
    public ModelAndView getPage(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("comment",new Comment());
        modelAndView.addObject("commentList",service.findAll());
        return modelAndView;
    }

    @PostMapping()
    String addComment(@ModelAttribute Comment comment){
        service.save(comment);
        return "redirect:/nasa";
    }
}
