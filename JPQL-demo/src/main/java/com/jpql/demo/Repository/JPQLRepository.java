package com.jpql.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.jpql.demo.Model.JPQLModel;

@Repository
public interface JPQLRepository extends JpaRepository<JPQLModel, Integer> {

	@Query(value = "SELECT * FROM user",nativeQuery = true)
	public List<JPQLModel> getAllUser();
	
	@Query(value = "SELECT * FROM user WHERE name = ?1",nativeQuery = true)
	public List<JPQLModel> getAllUserByName(String name);


}
