package com.abayllc.restchapetex.rest;

import com.abayllc.restchapetex.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    private List<Student> theStudents = new ArrayList<>();

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
     StudentErrorResponse response = new StudentErrorResponse();
     response.setStatus(HttpStatus.NOT_FOUND.value());
     response.setMesssage(exc.getMessage());
     response.setTimestamp(System.currentTimeMillis());
     return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
        StudentErrorResponse response = new StudentErrorResponse();
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setMesssage(exc.getMessage());
        response.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

    }

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

        if(id > theStudents.size() || id <0){
            throw  new StudentNotFoundException("No student found with id "+ id);
        }
        return theStudents.get(id);

    }

}
