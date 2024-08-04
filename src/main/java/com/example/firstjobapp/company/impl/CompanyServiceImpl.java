package com.example.firstjobapp.company.impl;

import java.util.*;

import org.springframework.stereotype.Service;

import com.example.firstjobapp.company.Company;
import com.example.firstjobapp.company.CompanyRepository;
import com.example.firstjobapp.company.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	private CompanyRepository companyRepository;

	public CompanyServiceImpl(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}

	@Override
	public List<Company> getAllCompanies() {
		return companyRepository.findAll();
	}

	@Override 
	public boolean updateCompany(Company company, long id){
		Optional<Company> companyOptional = companyRepository.findById(id);
		if(companyOptional.isPresent()){
			Company companyToUpdate = companyOptional.get();
			// companyToUpdate.setID(company.getID());
			companyToUpdate.setName(company.getName());
			companyToUpdate.setDescription(company.getDiscription());
			companyToUpdate.setJobs(company.getJobs());
			companyRepository.save(companyToUpdate);
			return true;
			// companyToUpdate.setID(company.getID());
			// companyToUpdate.setID(company.getID());
			// companyToUpdate.setID(company.getID());
		}
		return false;
	}
	
	@Override
	public void createCompany(Company company){
		companyRepository.save(company);
	}

}
