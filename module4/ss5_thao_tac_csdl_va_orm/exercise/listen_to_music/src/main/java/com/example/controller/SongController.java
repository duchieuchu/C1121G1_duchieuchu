package com.example.controller;

import com.example.model.Song;
import com.example.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    private SongService songService;

    @GetMapping("")
    public String list(Model model) {
        List<Song> songList = songService.findAll();
        model.addAttribute("songList", songList);
        return "/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("song", new Song());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Song song) {
        songService.save(song);
        return "redirect:/song";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("song", songService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Song song) {
        songService.update(song.getId(), song);
        return "redirect:/song";
    }



    @GetMapping("/delete")
    public String delete(@RequestParam Integer id) {
        Song song = this.songService.findById(id);

        this.songService.remove(song);
//        redirectAttributes.addFlashAttribute("mess", "Delete Success");
        return "redirect:/song";
    }

}
