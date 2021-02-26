package com.belt.exam.services;

import com.belt.exam.models.Review;
import com.belt.exam.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    private ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review create(Review review) {
        return reviewRepository.save(review);
    }
}
