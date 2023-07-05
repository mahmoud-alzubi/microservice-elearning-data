package com.mtech.elearning.controller;

import com.mtech.elearning.entity.Instructor;
import com.mtech.elearning.entity.InstructorDetail;
import com.mtech.elearning.service.InstructorServiceImpl;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructors")
public class InstructorController {
    private final InstructorServiceImpl service;

    @Autowired
    public InstructorController(InstructorServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    ResponseEntity<?> findAll() {
        List<Instructor> instructorList = service.findAllInstructors();
        return ResponseEntity.ok().body(instructorList);
    }

    @GetMapping("/{id}")
    ResponseEntity<?> findInstructorById(@PathVariable("id") int id) {
        Instructor instructor = service.findInstructorById(id);
        return ResponseEntity.ok().body(instructor);
    }

    @PostMapping
    ResponseEntity<?> save(@RequestBody Instructor instructor) {
        service.save(instructor);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Instructor instructor) {
        service.update(id, instructor);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable("id") int id) {
        service.deleteInstructorById(id);
        return ResponseEntity.noContent().build();
    }
}
