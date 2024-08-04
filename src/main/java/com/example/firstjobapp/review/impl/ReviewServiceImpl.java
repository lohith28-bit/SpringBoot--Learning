package com.example.firstjobapp.review.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.firstjobapp.review.Review;
import com.example.firstjobapp.review.ReviewRepository;
import com.example.firstjobapp.review.ReviewService;


@Service
public class ReviewServiceImpl implements ReviewService{

	private ReviewRepository reviewRepository;

	public ReviewServiceImpl(ReviewRepository reviewRepository){
		this.reviewRepository = reviewRepository;
	}

	// public List<Review> getAllReviews(Long companyId){

		// Optional<Review> reviewOptional = reviewRepository.
		
	// }
}
