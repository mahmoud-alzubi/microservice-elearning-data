package com.mtech.elearning.service;

import com.mtech.elearning.entity.Review;
import com.mtech.elearning.repository.ReviewRepositoryImpl;
import com.mtech.elearning.repository.StudentRepositoryImpl;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private final ReviewRepositoryImpl repository;

    //////////////////////////////////////////////////

    /**
     * Class Constructor
     *
     * @param repository
     */
    @Autowired
    public ReviewServiceImpl(ReviewRepositoryImpl repository) {
        this.repository = repository;
    }

    //////////////////////////////////////////////////

    /**
     * To Retrieve All Review Records
     *
     * @return
     */
    @Override
    public List<Review> findAll() {
        try {
            logger.info("findAll()");
            List<Review> reviewList = repository.findAll();
            return reviewList;
        } finally {
            logger.info("/findAll()");
        }
    }

    //////////////////////////////////////////////////

    /**
     * To Find Review By ID
     *
     * @param id
     * @return
     */
    @Override
    public Review findReviewById(int id) {
        try {
            logger.info("findReviewById({})", id);
            Review review = repository.findReviewById(id);
            return review;
        } finally {
            logger.info("/findReviewById({})", id);
        }
    }

    //////////////////////////////////////////////////

    /**
     * To Add New Review Record
     *
     * @param review
     */
    @Override
    @Transactional
    public void save(Review review) {
        try {
            logger.info("save({})", review);
            repository.save(review);
        } finally {
            logger.info("/save({})", review);
        }
    }

    //////////////////////////////////////////////////

    /**
     * To Update Review Revord
     *
     * @param id
     * @param review
     */
    @Override
    @Transactional
    public void update(int id, Review review) {
        try {
            logger.info("update({}, {})", id, review);
            review.setId(id);
            repository.update(review);
        } finally {
            logger.info("/update({}, {})", id, review);
        }
    }

    //////////////////////////////////////////////////

    /**
     * To Delete Review Record
     *
     * @param id
     */
    @Override
    public void deleteReview(int id) {
        try {
            logger.info("deleteReview({})", id);
            Review review = repository.findReviewById(id);
            if (review == null) {
                // throw review not found exception..
            }
            repository.deleteReview(review);
        } finally {
            logger.info("/deleteReview({})", id);
        }
    }


}
