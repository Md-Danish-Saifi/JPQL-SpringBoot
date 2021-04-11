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
import com.jpql.demo.Model.JPQLModel;
import com.jpql.demo.Repository.JPQLRepository;
import com.jpql.demo.Service.JPQLService;


@RestController
@RequestMapping("/api/")
public class JPQLController {

	@Autowired
	private JPQLRepository repo;
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

	@PostMapping("save")
	@Transactional
	@CrossOrigin
	@Validated
	public String saveUser(@Validated @RequestBody JPQLModel user)
	{

		service.addUser(user);
		return "Job "+user.getName()+ " successfully added";
	}

}
