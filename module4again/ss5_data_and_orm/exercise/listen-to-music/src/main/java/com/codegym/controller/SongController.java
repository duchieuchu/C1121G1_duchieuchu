package com.codegym.controller;

import com.codegym.model.Song;
import com.codegym.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/song")
@Controller
public class SongController {
    @Autowired
    private ISongService iSongService;

    @GetMapping("")
    public String goList(Model model) {
        List<Song> songList = this.iSongService.findAll();
        model.addAttribute("songList", songList);
        return "/list";
    }

    @GetMapping("/showCreateForm")
    public String showCreateForm(Model model) {
        model.addAttribute("song", new Song());
        return "/create";
    }

    @PostMapping("/create")
    public String create(Song song) {
        this.iSongService.save(song);
        return "redirect:/song";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id) {
        Song song = this.iSongService.findById(id);
        this.iSongService.delete(song);
        return "redirect:/song";
    }
}
