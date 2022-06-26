package com.example.controller;

import com.example.dto.UserDto;
import com.example.model.User;
import com.example.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping("")
    public String showForm(Model model) {
        model.addAttribute("userDto",new UserDto());
//        model.addAttribute("user", new User());
        return "/index";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute @Valid UserDto userDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         Model model) {
        new UserDto().validate(userDto,bindingResult);
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("msgError","đăng kí thất bại");
            return "redirect:/user";
        }else {
            User user=new User();
            BeanUtils.copyProperties(userDto,user);
            this.iUserService.save(user);
            model.addAttribute("msg","Đã đăng kí "+user.getFirstName()+" "+user.getLastName()+ " thành công");
            return "/result";
        }
    }

}
