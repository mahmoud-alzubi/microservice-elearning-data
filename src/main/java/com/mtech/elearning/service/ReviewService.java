package com.mtech.elearning.service;

import com.mtech.elearning.entity.Review;

import java.util.List;

public interface ReviewService {
    List<Review> findAll();
    Review findReviewById(int id);

    void save(Review review);

    void update(int id, Review review);

    void deleteReview(int id);

}
