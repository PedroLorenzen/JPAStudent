package com.example.jpastudent.config;

import com.example.jpastudent.model.Student;
import com.example.jpastudent.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {

        Student s1 = new Student();
        s1.setBornDate(LocalDate.of(2000,10,11));
        s1.setBornTime(LocalTime.now());
        s1.setName("Erik");
        studentRepository.save(s1);
        s1.setName("Bruce");
        studentRepository.save(s1);
        s1.setName("Finish");
        studentRepository.save(s1);



    }
}
