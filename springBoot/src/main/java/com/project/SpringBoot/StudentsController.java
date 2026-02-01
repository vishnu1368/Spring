package com.project.SpringBoot;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentsController {
    List<Student> Student = new ArrayList<>(List.of(
       new Student(1, "Aakash", 80),
       new Student(2, "Bharat", 98)
    ));

    @GetMapping("/students")
    public List<Student> getStudents(){
        return Student;
    }
    @PostMapping("/students")
    public Student addStudents(@RequestBody Student student){
        Student.add(student);
        return student;
    }

    @GetMapping("/getCSRF")
    public CsrfToken getCSRFToken(CsrfToken token){
        return token;
    }
}
