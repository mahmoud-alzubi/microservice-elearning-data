package com.mtech.elearning.repository;

import com.mtech.elearning.entity.Review;

import java.util.List;

public interface ReviewRepository {

    List<Review> findAll();
    Review findReviewById(int id);

    void save(Review review);

    void update(Review review);

    void deleteReview(Review review);

}
