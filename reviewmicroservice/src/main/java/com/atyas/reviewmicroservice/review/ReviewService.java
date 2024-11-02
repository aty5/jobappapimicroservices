package com.atyas.reviewmicroservice.review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);

    List<Review> findAll();
    boolean addReview(Long companyId, Review review);

    Review getReview(Long reviewId);

    boolean updateReview(Long reviewId, Review review);

    boolean deleteReview(Long reviewId);
}
