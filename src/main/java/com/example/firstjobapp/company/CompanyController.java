package com.example.firstjobapp.company;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/companies")
public class CompanyController {

	private CompanyService companyService;

	public CompanyController(CompanyService companyService) {
		this.companyService = companyService;
	}

	@GetMapping
	public ResponseEntity<List<Company>> getAllCompanies(@PathVariable Long companyId) {
		return ResponseEntity.ok(companyService.getAllCompanies());
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateCompany(@RequestBody Company company, @PathVariable long id){
		if(companyService.updateCompany(company, id)){
			return new ResponseEntity<>("Company details updated successfully",HttpStatus.ACCEPTED);
		}
		return ResponseEntity.status(403).body("Unable to update the Company.");
	}

	@PostMapping
	public ResponseEntity<String> createCompany(@RequestBody Company company){
		return ResponseEntity.status(HttpStatus.CREATED).body("Company added successfully");
	}


	// @PostMapping
	// public String postMethodName(@RequestBody Company entity, @PathVariable Long companyId) {
	// 	// * TODO: process POST request
	// 	return "entity";
	// }

	// @GetMapping("/{reviewId}")
	// public String getMethodName(@PathVariable Long companyId, @PathVariable Long reviewId) {
	// 	return new String();
	// }

	// @PutMapping("/{reviewId}")
	// public String putMethodName(@PathVariable Long companyId, @PathVariable Long reviewId, @RequestBody String entity) {
	// 	// * TODO: process PUT request

	// 	return entity;
	// }

	// @DeleteMapping("/{reviewId}")
	// public String delectCompanyByID(@PathVariable long companyId, @PathVariable Long reviewId) {
	// 	return "Succefully delected";
	// }



}
