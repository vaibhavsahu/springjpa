package com.vaibhav.example.springjpa.Service;


import com.vaibhav.example.springjpa.Repository.StudentRepository;
import com.vaibhav.example.springjpa.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {


    private final StudentRepository studentRepository;


    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAll(){
        List<Student> list = studentRepository.getAll();
        return list;
    }
}
