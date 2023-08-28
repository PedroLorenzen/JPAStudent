package com.example.jpastudent.controller;

import com.example.jpastudent.model.Student;
import com.example.jpastudent.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
<<<<<<< Updated upstream
import org.springframework.web.client.HttpClientErrorException;
=======
>>>>>>> Stashed changes

import java.util.List;
import java.util.Optional;

@RestController
public class StudentRestController
{

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/students")
    public List<Student> listStudents()
    {
        return studentRepository.findAll();
    }

    @PostMapping("/student")
    @ResponseStatus(HttpStatus.CREATED)
<<<<<<< Updated upstream
    public Student postStudent(@RequestBody Student student) {
=======
    public Student createStudent(@RequestBody Student student)
    {
>>>>>>> Stashed changes
        System.out.println(student);
        return studentRepository.save(student);
    }

<<<<<<< Updated upstream
    @PutMapping("/student")
    @ResponseStatus(HttpStatus.CREATED)
    public Student putStudent(@RequestBody Student student) {
        System.out.println(student);
        return studentRepository.save(student);
    }


=======
    @PutMapping("/student/{id}")
    public ResponseEntity<Student> putStudent(@PathVariable int id, @RequestBody Student student)
    {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if ( studentOptional.isPresent() )
        {
            student.setId(id);  // Set the ID on the incoming student object
            studentRepository.save(student);  // Save it, effectively updating the existing record
            return new ResponseEntity<>(student, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
>>>>>>> Stashed changes
}
