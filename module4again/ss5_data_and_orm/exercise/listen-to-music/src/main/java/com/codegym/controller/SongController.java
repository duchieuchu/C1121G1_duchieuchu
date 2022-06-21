package com.codegym.controller;

import com.codegym.model.Song;
import com.codegym.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("{id}/edit")
    public String showEditForm(@PathVariable Integer id, Model model) {
        model.addAttribute("song", this.iSongService.findById(id));
        return "/edit";
    }

    @PostMapping("/edit")
    public String edit(Song song){
        this.iSongService.update(song.getId(),song);
        return "redirect:/song";
    }
}
