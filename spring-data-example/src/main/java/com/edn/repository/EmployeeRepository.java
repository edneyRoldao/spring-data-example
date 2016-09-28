package com.edn.repository;

import org.springframework.data.repository.CrudRepository;

import com.edn.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, String>{
}
