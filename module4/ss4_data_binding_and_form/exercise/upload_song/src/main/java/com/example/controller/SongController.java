package com.example.controller;

import com.example.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/song")
public class SongController {
    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String goShowForm(ModelMap modelMap) {
        modelMap.addAttribute("song", new Song());
        return "song/create";
    }

    @RequestMapping(value = "/addSong", method = RequestMethod.POST)
    public String submit(@ModelAttribute("song") Song song, ModelMap modelMap) {
        modelMap.addAttribute("name", song.getName());
        modelMap.addAttribute("singer", song.getSinger());
        modelMap.addAttribute("kindOfMusic", song.getKindOfMusic());
        modelMap.addAttribute("filePath", song.getFilePath());
        return "song/info";
    }
}
