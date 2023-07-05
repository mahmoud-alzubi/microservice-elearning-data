package com.mtech.elearning.controller;

import com.mtech.elearning.entity.InstructorDetail;
import com.mtech.elearning.service.InstructorDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructor-details")
public class InstructorDetailController {
    private final InstructorDetailServiceImpl detailService;

    @Autowired
    public InstructorDetailController(InstructorDetailServiceImpl detailService) {
        this.detailService = detailService;
    }

    @GetMapping
    ResponseEntity<?> findAll() {
        List<InstructorDetail> instructorDetailList = detailService.findAllInstructorDetails();
        return ResponseEntity.ok().body(instructorDetailList);
    }

    @GetMapping("/{id}")
    ResponseEntity<?> findInstructorDetailById(@PathVariable("id") int theId) {
        InstructorDetail instructorDetail = detailService.findInstructorDetailById(theId);
        return ResponseEntity.ok().body(instructorDetail);
    }

    @PostMapping
    ResponseEntity<?> save(@RequestBody InstructorDetail instructorDetail) {
        detailService.save(instructorDetail);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody InstructorDetail instructorDetail) {
        detailService.update(id, instructorDetail);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable("id") int id) {
        detailService.deleteInstructorDetail(id);
        return ResponseEntity.noContent().build();
    }
}
