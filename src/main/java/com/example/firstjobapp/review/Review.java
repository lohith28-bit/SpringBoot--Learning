package com.example.firstjobapp.review;

import com.example.firstjobapp.company.Company;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;
	private Double rating;

	@ManyToOne
	private Company company;

	public Review() {

	}

	public Review(Long id, String title, String description, double rating, Company company) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.rating = rating;
		this.company = company;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long value) {
		this.id = value;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String value) {
		this.title = value;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String value) {
		this.description = value;
	}

	public Double getRating() {
		return this.rating;
	}

	public void setRating(Double value) {
		this.rating = value;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company value) {
		this.company = value;
	}

}
