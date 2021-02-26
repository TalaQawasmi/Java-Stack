package com.belt.services;

import com.belt.models.Review;
import com.belt.repositories.ReviewRepository;
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
