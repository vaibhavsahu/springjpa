package com.vaibhav.example.springjpa;

import com.vaibhav.example.springjpa.Controller.StudentController;
import com.vaibhav.example.springjpa.Model.Student;
import com.vaibhav.example.springjpa.Service.StudentService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvc.*;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class StudentControllerTest {

    private StudentController studentController;
    private StudentService studentService;
    private List<Student> studentList;

    private MockMvc mockMvc;

    public StudentControllerTest(){
        studentService = Mockito.mock(StudentService.class);
        studentController = new StudentController(studentService);
        studentList = Arrays.asList(new Student("test", "test", "test@test.com"));
    }

    @Before
    public void setup(){
        this.mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
    }

    @Test
    @DisplayName( "Students List Returned")
    public void whenStudentsExist_thenHttp200_andStudentsListReturned() throws Exception {
        Mockito.doReturn(studentList).when(studentService).getAll();
        mockMvc.perform(MockMvcRequestBuilders.get("/all"))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()));
       MvcResult response =  mockMvc.perform(MockMvcRequestBuilders.get("/all"))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value())).andReturn();

       String content = response.getResponse().getContentAsString();
       assertEquals(true, content.contains("test"));
       assertEquals(true, content.contains("test@test.com"));
    }

    @Test
    @DisplayName("Student List is Null")
    public void whenStudentsNotExist_thenHttp404() throws Exception {
        Mockito.doReturn(null).when(studentService).getAll();
        mockMvc.perform(MockMvcRequestBuilders.get("/all"))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.NOT_FOUND.value()));
    }
}
