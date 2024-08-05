package com.example.firstjobapp.review.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.firstjobapp.company.CompanyRepository;

import com.example.firstjobapp.company.Company;
import com.example.firstjobapp.review.Review;
import com.example.firstjobapp.review.ReviewRepository;
import com.example.firstjobapp.review.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

	private ReviewRepository reviewRepository;

	@Autowired
	private CompanyRepository companyRepository;

	public ReviewServiceImpl(ReviewRepository reviewRepository) {
		this.reviewRepository = reviewRepository;
	}

	public void addReview(Long companyId, Review review) {
		Company company = new Company();
		company.setID(companyId);
		review.setCompany(company);
		reviewRepository.save(review);
	}

	public List<Review> getAllReviews(Long companyId) {
		List<Review> reviewsLoop = reviewRepository.findAll();
		List<Review> resultReview = new ArrayList<>();

		reviewsLoop.forEach(r -> {
			if (r.getCompany().getID().equals(companyId)) {
				resultReview.add(r);
			}
		});
		return resultReview;
	}

	public Review getOneReview(Long reviewId) {
		return reviewRepository.findById(reviewId).orElse(null);
	}

	public Boolean updateReviewById(Long companyId, Long reviewId, Review review) {
		Optional<Review> optionalReview = reviewRepository.findById(reviewId);
		if (optionalReview.isPresent()) {
			Review updatedReview = optionalReview.get();
			updatedReview.setTitle(review.getTitle());
			updatedReview.setDescription(review.getDescription());
			updatedReview.setRating(review.getRating());
			Optional<Company> optionalCompany = companyRepository.findById(companyId);
			if (optionalCompany.isPresent()) {
				Company company = optionalCompany.get();
				updatedReview.setCompany(company);
			} else {
				return false;
			}
			reviewRepository.save(updatedReview);
			return true;
		}
		return false;
	}

	public Boolean deleteReviewById(Long reviewId) {
		if (reviewRepository.existsById(reviewId)) {
			reviewRepository.deleteById(reviewId);
			return true;
		}
		return false;
	}
}
