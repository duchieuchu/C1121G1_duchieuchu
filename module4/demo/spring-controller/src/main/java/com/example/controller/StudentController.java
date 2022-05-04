package com.example.controller;

import com.example.model.Student;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

//    @GetMapping (value = "/list")
//    public String goStudentList(ModelMap modelMap){
////        modelMap.addAttribute("studentList",studentService.findAll());
//        modelMap.put("studentList",this.studentService.findAll());
//        return "studentList";
//    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ModelAndView goStudentList(){
        ModelAndView modelAndView = new ModelAndView("studentList");
        modelAndView.addObject("studentList",this.studentService.findAll());
        return modelAndView;
    }

    @GetMapping( value = "/detail")
    public String goDetailStudent(@RequestParam Integer id, Model model){
        Student student = this.studentService.findById(id);
        model.addAttribute("student",student);
        return "detailStudent";
    }

    @GetMapping( value = "/detail/{id}")
    public String goDetailStudentPV(@PathVariable Integer id , Model model){
        Student student = this.studentService.findById(id);
        model.addAttribute("student",student);
        return "detailStudent";
    }



}
