package com.example.controller;

import com.example.model.Contract;
import com.example.model.Room;
import com.example.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private IRoomService iRoomService;

    @GetMapping("")
    public String goList(Model model, @PageableDefault(value = 4) Pageable pageable) {
        Page<Room> roomPage = iRoomService.findAll(pageable);
        model.addAttribute("roomPage", roomPage);
        return "views/room/list";
    }

    @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable Integer id, Model model) {
        model.addAttribute("room", iRoomService.findById(id));
        return "views/room/edit";
    }

    @PostMapping("/update")
    public String edit(Room room , RedirectAttributes redirectAttributes){
        iRoomService.save(room);
        redirectAttributes.addFlashAttribute("msg", "Edit Completed room: " + room.getRoomCode());
        return "redirect:/room";
    }
}
