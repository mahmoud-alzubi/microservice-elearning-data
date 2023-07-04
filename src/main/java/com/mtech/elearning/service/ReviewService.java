package com.mtech.elearning.service;

import com.mtech.elearning.entity.Review;

public interface ReviewService {

    Review findReviewById(int id);

    void save(Review review);

    void update(int id, Review review);

    void deleteReview(int id);

}
