package com.jpql.demo.Controller;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpql.demo.Model.Company;
import com.jpql.demo.Model.JPQLModel;
import com.jpql.demo.Repository.CompanyRepository;
import com.jpql.demo.Repository.JPQLRepository;
import com.jpql.demo.Service.JPQLService;


@RestController
@RequestMapping("/api/")
public class JPQLController {

	@Autowired
	private JPQLRepository repo;
	@Autowired
	private CompanyRepository comrepo;
	
	@Autowired
	private JPQLService service;


	@RequestMapping("/")
	@ResponseBody
	public String empty()
	{
		return "Hello you are on JPQL first Page";
	}

	@GetMapping(path="/findall")
	@CrossOrigin
	public @ResponseBody Iterable<JPQLModel> getAllEmp() {
		return repo.findAll();
	}

	@GetMapping(path="/all")
	@CrossOrigin
	public @ResponseBody Iterable<JPQLModel> getAll() {
		return repo.getAllUser();
	}
	
	@GetMapping(path="/byname")
	@CrossOrigin
	public @ResponseBody Iterable<JPQLModel> getAllByName() {
		return repo.getAllUserByName("baba");
	}

	@PostMapping("adduser")
	@Transactional
	@CrossOrigin
	@Validated
	public String saveUser(@Validated @RequestBody JPQLModel user)
	{
		try
		{
			if(user.getName()==null || user.getName().isEmpty())
			{
				return "username can't empty";
			}
			if(user.getEmail()==null || user.getEmail().isEmpty())
			{
				return "Email can't empty";
			}
			if(user.getPhone()==null || user.getPhone().isEmpty())
			{
				return "Phone can't empty";
			}
			if(user.getAddress()==null || user.getAddress().isEmpty())
			{
				return "Address can't empty";
			}
		}
		catch (Exception e)
		{
			return "invalid parameter";	
		}
		service.addUser(user);
		return "user "+user.getName()+ " successfully added";
	}
	
	@PostMapping("addcompany")
	@Transactional
	@CrossOrigin
	@Validated
	public String saveCompany(@Validated @RequestBody Company company)
	{
		try
		{
			if(company.getCompanyName()==null || company.getCompanyName().isEmpty())
			{
				return "Company name can't empty";
			}
			if(company.getAddress()==null || company.getAddress().isEmpty())
			{
				return "address can't empty";
			}
			if(company.getBranch()==null || company.getBranch().isEmpty())
			{
				return "branch can't empty";
			}

		}
		catch (Exception e)
		{
			return "invalid parameter";	
		}
		int countCompany = 0;
		try 
		{
			countCompany = comrepo.countByCompanyName(company.getCompanyName());
		}
		catch (Exception e) {
			return "Exceptoin cought in countCompany";
		}
		if(countCompany>0)
		{
			return "compnay "+company.getCompanyName()+" Already exist!";
		}
		service.addCompany(company);
		return "Company "+company.getCompanyName()+ " successfully added";
	}

}
