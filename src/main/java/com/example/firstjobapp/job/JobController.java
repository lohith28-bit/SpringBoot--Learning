package com.example.firstjobapp.job;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/jobs")
public class JobController {

	private JobService jobService;
	
	public JobController(JobService jobService) {
		this.jobService = jobService;
	}

	@GetMapping
	public ResponseEntity<List<Job>> findAll() {
		return ResponseEntity.ok(jobService.findAll());
	}

	@PostMapping
	public ResponseEntity<String> createJob(@RequestBody Job job) {
		jobService.createJob(job);
		return new ResponseEntity<>("Job created successfully", HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getJobById(@PathVariable("id") Long id) {
		Job job = jobService.getJobById(id);
		if (job != null) {
			return new ResponseEntity<>(job, HttpStatus.OK);
		}
		return new ResponseEntity<>("Job not found",HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteJobByID(@PathVariable("id") Long id) {
		if (Boolean.TRUE.equals(jobService.deleteJobByID(id))) {
			return ResponseEntity.ok("Job ID deleted successfully");
		}
		return ResponseEntity.status(404).body("Job ID not found");
	}

	// @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@PutMapping("/{id}")
	public ResponseEntity<String> updatedJob(@PathVariable Long id, @RequestBody Job job) {
		boolean updated = jobService.updateJob(id, job);
		if (updated) {
			return new ResponseEntity<>("Job updated successfully", HttpStatus.OK);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Job not found");
	}

}
