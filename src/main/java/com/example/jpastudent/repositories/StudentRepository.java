package com.example.jpastudent.repositories;

import com.example.jpastudent.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer>
{
    Optional<Student> findByName(String name);
}
