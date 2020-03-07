package com.vaibhav.example.springjpa.Controller;


import com.vaibhav.example.springjpa.Model.Student;
import com.vaibhav.example.springjpa.Service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

import static javax.servlet.http.HttpServletResponse.SC_NOT_FOUND;
import static javax.servlet.http.HttpServletResponse.SC_OK;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("/all")
    public ResponseEntity listAllStudents(){
        List<Student> list = studentService.getAll();
        if(Objects.nonNull(list)){
            return ResponseEntity.status(SC_OK).body(list);
        }
        return ResponseEntity.status(SC_NOT_FOUND).body(null);
    }

}
