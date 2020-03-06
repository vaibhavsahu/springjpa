package com.vaibhav.example.springjpa.Controller;


import com.vaibhav.example.springjpa.Model.Student;
import com.vaibhav.example.springjpa.Service.StudentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("/test")
    public List<Student> hello(){
        List<Student> list = studentService.getAll();
        return list;
    }

}
