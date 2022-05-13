package com.example.controller;

import com.example.dto.UserDto;
import com.example.model.User;
import com.example.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService iUserService;

    @RequestMapping("")
    public String list(Model model, @PageableDefault(value = 4) Pageable pageable) {
        Page<User> userList = iUserService.findAll(pageable);
        model.addAttribute("userList", userList);
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
     model.addAttribute("userDto",new UserDto());
        return "/create";
    }

    @PostMapping("/save")
    public String create(@ModelAttribute @Validated UserDto userDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "/create";
        } else {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            iUserService.save(user);
            redirectAttributes.addFlashAttribute("mess",
                    "create user: " + user.getFirstName() + " completed");
        }
        return "redirect:/create";
    }


//        @PostMapping("/save")
//    public String save(User user, RedirectAttributes redirectAttributes) {
//        iUserService.save(user);
//        redirectAttributes.addFlashAttribute("mess", "Create user Completed");
//        return "redirect:/user";
//    }
    @GetMapping("/delete")
    public String delete(User user, RedirectAttributes redirectAttributes) {
        this.iUserService.remove(user);
        redirectAttributes.addFlashAttribute("mess", "Delete user Completed");
        return "redirect:/user";
    }
}
