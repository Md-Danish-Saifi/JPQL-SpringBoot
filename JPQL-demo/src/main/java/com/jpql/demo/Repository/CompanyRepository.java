package com.jpql.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jpql.demo.Model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

	int countByCompanyName(String companyName);

}
