package com.example.firstjobapp.company;

import java.util.*;

import org.springframework.stereotype.Service;

@Service
public interface CompanyService {
	// void findAllCompany();
	// void createCompany(Company company);
	// Company getcompanybyId(Long id);
	// Boolean delectCompanyByID(Long id);
	// Boolean updateCompany(Long id);
	List<Company> getAllCompanies(); 

	boolean updateCompany(Company company, long id);

	void createCompany(Company company);
}
