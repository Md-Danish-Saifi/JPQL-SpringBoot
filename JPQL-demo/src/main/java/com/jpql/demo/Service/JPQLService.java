package com.jpql.demo.Service;

import org.springframework.stereotype.Service;

import com.jpql.demo.Model.JPQLModel;
import com.jpql.demo.Repository.JPQLRepository;

@Service
public class JPQLService {

	private JPQLRepository repo;

	public JPQLService(JPQLRepository repo) {
		super();
		this.repo = repo;
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
	
	
}
