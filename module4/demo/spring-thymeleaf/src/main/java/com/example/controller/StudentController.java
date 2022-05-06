package com.example.controller;

import com.example.model.Student;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
//hien thi list
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView goStudentList() {
        ModelAndView modelAndView = new ModelAndView("studentList");
        modelAndView.addObject("studentList", this.studentService.findAll());
        return modelAndView;
    }

    @GetMapping(value = "/detail")
    public String goDetailStudent(@RequestParam Integer id, Model model) {
        Student student = this.studentService.findById(id);
        model.addAttribute("student", student);
        return "detailStudent";
    }

    @GetMapping(value = "/detail/{id}")
    public String goDetailStudentPV(@PathVariable Integer id, Model model) {
        Student student = this.studentService.findById(id);
        model.addAttribute("student", student);
        return "detailStudent";
    }
//hien thi create co su dung modelAttribute de lien ket du lieu model va view
    @GetMapping(value = "/create")
    public String goCreateStudent(Model model) {
        model.addAttribute("student", new Student());
        return "createStudent";
    }
// chuc nang create
    @PostMapping(value = "/create")
    public String createStudent( Student student, RedirectAttributes redirectAttributes) {
        this.studentService.save(student);
        redirectAttributes.addFlashAttribute("msg", "Completed");
        return "redirect:/student/list";
    }

}
