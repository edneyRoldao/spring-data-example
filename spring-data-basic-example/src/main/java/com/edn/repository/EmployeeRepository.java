package com.edn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edn.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	List<Employee> findEmployeesByAge(int age);
	
	List<Employee> findEmployeesByName(String name);
	
	List<Employee> findEmployeesByAgeGreaterThan(int age);
	
	@Query("SELECT e FROM Employee e WHERE e.age >= ?1 AND e.age <= ?2")
	List<Employee> findEmployeesBetweenAge(int idadeDe, int idadeAte);
	
}
