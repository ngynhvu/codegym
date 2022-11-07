package com.example.music.controller;


import com.example.music.model.Music;
import com.example.music.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MusicController {
    @Autowired
    private MusicService musicService;

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("music", new Music());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveMusic(@ModelAttribute("music") Music music) {
        musicService.save(music);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("music", new Music());
        modelAndView.addObject("message", "New music created successfully");
        return modelAndView;
    }
    @GetMapping("/musics")
    public ModelAndView listCustomers() {
        List<Music> musics = musicService.findAll();
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("musics", musics);
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable int id) {
        Music music = musicService.findById(id);
        if (music != null) {
            ModelAndView modelAndView = new ModelAndView("/edit");
            modelAndView.addObject("music", music);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }
    @PostMapping("/edit")
    public ModelAndView updateCustomer(@ModelAttribute("music") Music music) {
        musicService.save(music);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("music", music);
        modelAndView.addObject("message", "Music updated successfully");
        return modelAndView;
    }
}
