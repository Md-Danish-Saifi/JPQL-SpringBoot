package com.jpql.demo.Service;

import org.springframework.stereotype.Service;

import com.jpql.demo.Model.Company;
import com.jpql.demo.Model.JPQLModel;
import com.jpql.demo.Repository.CompanyRepository;
import com.jpql.demo.Repository.JPQLRepository;

@Service
public class JPQLService {

	private JPQLRepository repo;
	private CompanyRepository companyRepo;

	public JPQLService(JPQLRepository repo, CompanyRepository companyRepo) {
		super();
		this.repo = repo;
		this.companyRepo = companyRepo;
	}


	public void addUser(JPQLModel user)
	{
		repo.save(user);
	}
	
	public Iterable<JPQLModel> removeUser(int id)
	{
		repo.deleteById(id);
		return repo.findAll();
	}

	public void addCompany(Company company) 
	{	
		companyRepo.save(company);
	}
	
	
}
