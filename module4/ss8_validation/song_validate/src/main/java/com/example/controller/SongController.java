package com.example.controller;

import com.example.dto.SongDto;
import com.example.model.Song;
import com.example.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    private ISongService iSongService;

    @RequestMapping("")
    public String list(Model model, @PageableDefault(value = 4) Pageable pageable) {
        Page<Song> songPage = iSongService.findAll(pageable);
        model.addAttribute("songPage", songPage);
        return "list";
    }
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("songDto",new SongDto());
        return "/create";
    }

    @PostMapping("/save")
    public String create(@ModelAttribute @Validated SongDto songDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        new SongDto().validate(songDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "/create";
        } else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto, song);
            iSongService.save(song);
            redirectAttributes.addFlashAttribute("mess",
                    "create song: " + song.getName() + " completed");
        }
        return "redirect:/song";
    }
    @GetMapping("/delete")
    public String delete(Song song, RedirectAttributes redirectAttributes) {
        this.iSongService.remove(song);
        redirectAttributes.addFlashAttribute("mess", "Delete song Completed");
        return "redirect:/song";
    }

}
