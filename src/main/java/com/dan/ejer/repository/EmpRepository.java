package com.dan.ejer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.dan.ejer.entity.Employee;

@Repository
public interface EmpRepository extends JpaRepository<Employee, Integer>{
	
	public List<Employee> findByEmail(String email);	
	public List<Employee> findByEmailStartingWithOrSalary(String email, int salary);	
	
	@Query("SELECT e FROM Employee e WHERE LOWER(e.first_name) LIKE LOWER (:searchword)")
	public List <Employee> findEmployee(@Param("searchword") String searchword);

	public List <Employee> findEmployeeEmail(@Param("searchword") String searchword);
	
	
}
 