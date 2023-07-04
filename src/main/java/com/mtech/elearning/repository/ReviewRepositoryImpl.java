package com.mtech.elearning.repository;

import com.mtech.elearning.entity.Review;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReviewRepositoryImpl implements ReviewRepository {
    private final EntityManager entityManager;

    @Autowired
    public ReviewRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Review findReviewById(int id) {
        Review review = entityManager.find(Review.class, id);
        return review;
    }

    @Override
    public void save(Review review) {
        entityManager.persist(review);
    }

    @Override
    public void update(Review review) {
        entityManager.merge(review);
    }

    @Override
    public void deleteReview(Review review) {
        entityManager.remove(review);
    }

}
