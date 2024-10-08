package com.example.firstjobapp.review;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies/{companyId}/reviews")
public class ReviewController {

	private ReviewService reviewService;

	public ReviewController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}

	@GetMapping
	public ResponseEntity<List<Review>> getAllReviews(@PathVariable long companyId) {
		List<Review> reviews = reviewService.getAllReviews(companyId);
		if (!reviews.isEmpty()) {
			return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.ACCEPTED);
		}

		return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<String> addReview(@PathVariable long companyId, @RequestBody Review review) {
		reviewService.addReview(companyId, review);
		return new ResponseEntity<>("Review added successfully", HttpStatus.CREATED);
	}

	@GetMapping("/{reviewId}")
	public ResponseEntity<?> getOneReview(@PathVariable long companyId, @PathVariable long reviewId) {
		Review review = reviewService.getOneReview(companyId, reviewId);

		if (review != null) {
			return new ResponseEntity<>(review, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Review Not Found", HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/{reviewId}")
	public ResponseEntity<String> updateReviewById(@PathVariable long companyId, @PathVariable long reviewId,
			@RequestBody Review review) {
		if (Boolean.TRUE.equals(reviewService.updateReviewById(companyId, reviewId, review))) {
			return ResponseEntity.accepted().body("Succesfully updated the review");
		}
		return ResponseEntity.accepted().body("Review Not Found");
	}

	@DeleteMapping("/{reviewId}")
	public ResponseEntity<String> deleteReviewById(@PathVariable long companyId, @PathVariable long reviewId) {
		if (Boolean.TRUE.equals(reviewService.deleteReviewById(companyId, reviewId))) {
			return new ResponseEntity<>("Review Deleted successfully", HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>("Review Deleted successfully", HttpStatus.NOT_FOUND);

	}

}
