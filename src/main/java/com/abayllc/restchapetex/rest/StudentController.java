package com.abayllc.restchapetex.rest;

import com.abayllc.restchapetex.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    private List<Student> theStudents = new ArrayList<>();

    @PostConstruct
    public void loadData(){
        theStudents.add(new Student("Abebe","Demis"));
        theStudents.add(new Student("Ananya","Abebe"));
        theStudents.add(new Student("Noah","Abebe"));
        theStudents.add(new Student("Aaron","Abebe"));
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudents;
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable int id){
        return theStudents.get(id);

    }

}
