package com.example.firstjobapp.review;

import java.util.List;

public interface ReviewService {

	List<Review> getAllReviews(Long companyId);

	void addReview(Long companyId, Review review);

	Review getOneReview(Long reviewId);

	Boolean updateReviewById(Long companyId, Long reviewId, Review review);

	Boolean deleteReviewById(Long reviewId);

}
