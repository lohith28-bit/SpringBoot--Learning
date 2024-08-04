package com.example.firstjobapp.company;

public class Review {
	private Long id;
	private String name;
	private Number rating;
	private String description;

	public Review(Long id, String name, Number rating, String description) {
		this.id = id;
		this.name = name;
		this.rating = rating;
		this.description = description;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Number getRating() {
		return this.rating;
	}

	public void setRating(Number value) {
		this.rating = value;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
