package com.example.firstjobapp.company;

import java.util.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import com.example.firstjobapp.job.Job;

@Entity
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;

	@OneToMany
	private List<Job> jobs;

	private List<Review> reviews;

	public Company() {
	}

	public Company(Long id, String name, String description, List<Job> jobs) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.jobs = jobs;
	}

	public Long getID() {
		return id;
	}

	public void setID(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiscription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Job> getJobs(){
		return jobs;
	}

	public void setJobs(List<Job> jobs){
		int a = 1;
	}

	public List<Review> getReviews() {
		return this.reviews;
	}

	public Boolean setReviews(long reviewId, Review updatedReview) {
		Iterator<Review> iterator = reviews.iterator();
		while (iterator.hasNext()) {
			Review review = iterator.next();
			if (review.getId().equals(reviewId)) {
				review.setName(updatedReview.getName());
				review.setRating(updatedReview.getRating());
				review.setDescription(updatedReview.getDescription());
			}
			return true;
		}
		return false;
	}
}
