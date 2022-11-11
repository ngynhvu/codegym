package com.example.validatesong.controller;

import com.example.validatesong.model.Song;
import com.example.validatesong.service.SongService;
import com.example.validatesong.validator.SongValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class SongController {
    @Autowired
    private SongService service;
    @Autowired
    private SongValidator validator;

    @GetMapping("/songs")
    public ModelAndView listCustomers() {
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("songs", service.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public String displayCreate(Model model) {
        model.addAttribute("song", new Song());
        return "index";
    }
    @PostMapping("create")
    public String create(@Validated @ModelAttribute("song") Song song, BindingResult bindingResult) {
        validator.validate(song,bindingResult);
        if (bindingResult.hasErrors()) {
            return "index";
        }
        service.save(song);
        return "redirect:/songs";
    }
    @GetMapping("/edit-customer/{id}")
    public ModelAndView showEditForm(@PathVariable int id) {
        Optional<Song> song = service.findById(id);
        if (song.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/edit");
            modelAndView.addObject("song", song.get());
            return modelAndView;
        } else {
            return new ModelAndView("");
        }
    }

    @PostMapping("/edit")
    public ModelAndView updateCustomer(@ModelAttribute("song") Song song) {
        service.save(song);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("song", song);
        modelAndView.addObject("message", "Customer updated successfully");
        return modelAndView;
    }

}
