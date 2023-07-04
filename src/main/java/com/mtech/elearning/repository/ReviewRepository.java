package com.mtech.elearning.repository;

import com.mtech.elearning.entity.Review;

public interface ReviewRepository {

    Review findReviewById(int id);

    void save(Review review);

    void update(Review review);

    void deleteReview(Review review);

}
