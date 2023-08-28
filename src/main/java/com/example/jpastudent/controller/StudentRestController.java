package com.example.jpastudent.controller;

import com.example.jpastudent.model.Student;
import com.example.jpastudent.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/studentByID/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id)
    {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if ( studentOptional.isPresent() )
        {
            return new ResponseEntity<>(studentOptional.get(), HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/studentByName/{name}")
    public ResponseEntity<Student> getStudent(@PathVariable String name)
    {
        Optional<Student> studentOptional = studentRepository.findByName(name);
        if ( studentOptional.isPresent() )
        {
            return new ResponseEntity<>(studentOptional.get(), HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/student")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student)
    {
        System.out.println(student);
        return studentRepository.save(student);
    }
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

    @DeleteMapping("/student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id)
    {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent())
        {
            studentRepository.deleteById(id);
            return ResponseEntity.ok("Student deleted");
        }
        else
        {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
