package com.mtech.elearning.controller;


import com.mtech.elearning.entity.Review;
import com.mtech.elearning.service.ReviewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    private final ReviewServiceImpl service;

    @Autowired
    public ReviewController(ReviewServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    ResponseEntity<?> findAll() {
        List<Review> reviewList = service.findAll();
        return ResponseEntity.ok().body(reviewList);
    }

    @GetMapping("/{id}")
    ResponseEntity<?> findReviewById(@PathVariable("id") int id) {
        Review review = service.findReviewById(id);
        return ResponseEntity.ok().body(review);
    }

    @PostMapping
    ResponseEntity<?> save(@RequestBody Review review) {
        service.save(review);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Review review) {
        service.update(id, review);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable("id") int id) {
        service.deleteReview(id);
        return ResponseEntity.noContent().build();
    }


}
