package com.mtech.elearning.controller;

import com.mtech.elearning.entity.Course;
import com.mtech.elearning.service.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseServiceImpl service;

    @Autowired
    public CourseController(CourseServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    ResponseEntity<?> findAll() {
        List<Course> courseList = service.findAllCourses();
        return ResponseEntity.ok().body(courseList);
    }

    @GetMapping("/{id}")
    ResponseEntity<?> findCourseById(@PathVariable("id") int id) {
        Course course = service.findCourseById(id);
        return ResponseEntity.ok().body(course);
    }

    @PostMapping
    ResponseEntity<?> save(@RequestBody Course course) {
        service.save(course);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Course course) {
        service.update(id, course);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable("id") int id) {
        service.deleteCourseById(id);
        return ResponseEntity.noContent().build();
    }
}
