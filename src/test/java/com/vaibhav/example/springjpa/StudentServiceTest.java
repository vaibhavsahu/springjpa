package com.vaibhav.example.springjpa;

import com.vaibhav.example.springjpa.Model.Student;
import com.vaibhav.example.springjpa.Repository.StudentRepository;
import com.vaibhav.example.springjpa.Service.StudentService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class StudentServiceTest {

    @InjectMocks
    private StudentService studentService;

    @Mock
    private StudentRepository studentRepository;


    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Student List Returned")
    public void getAllStudents(){
        List<Student> list = Arrays.asList(new Student("test", "test", "test@test.com"));
        when(studentRepository.getAll()).thenReturn(list);

        assertEquals(1, list.size());
        assertEquals("test", list.get(0).getFirstName());
        assertEquals("test", list.get(0).getLastName());
        assertEquals("test@test.com", list.get(0).getEmail());
    }

}
