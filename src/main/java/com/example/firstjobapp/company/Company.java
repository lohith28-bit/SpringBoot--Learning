package com.example.firstjobapp.company;

import java.util.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import com.example.firstjobapp.job.Job;
import com.example.firstjobapp.review.Review;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;

	@JsonIgnore
	@OneToMany(mappedBy = "company")
	private List<Job> jobs;

	@JsonIgnore
	@OneToMany(mappedBy = "company")
	private List<Review> review;

	public Company() {
	}

	public Company(Long id, String name, String description, List<Job> jobs, List<Review> review) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.jobs = jobs;
		this.review = review;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public List<Review> getReview() {
		return this.review;
	}

	public void setReview(List<Review> value) {
		this.review = value;
	}
}
