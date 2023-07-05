package com.mtech.elearning.controller;

import com.mtech.elearning.entity.Student;
import com.mtech.elearning.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentServiceImpl service;

    @Autowired
    public StudentController(StudentServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    ResponseEntity<?> findAll() {
        List<Student> studentList = service.findAll();
        return ResponseEntity.ok().body(studentList);
    }

    @GetMapping("/{id}")
    ResponseEntity<?> findStudentById(@PathVariable("id") int id) {
        Student student = service.findStudentById(id);
        return ResponseEntity.ok().body(student);
    }

    @PostMapping
    ResponseEntity<?> save(@RequestBody Student student) {
        service.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Student student) {
        service.update(id, student);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable("id") int id) {
        service.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }
}
