package com.edn.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;

import com.edn.config.JpaConfig;
import com.edn.model.Employee;
import com.edn.repository.EmployeeRepository;

@Transactional
@Import(JpaConfig.class)
@Configuration("mainBean")
@EnableJpaRepositories(basePackages = "com.edn.repository")
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	
	public void inserirOuAlterar(Employee e) {
		repository.save(e);
	}
	
	public void remover(Employee e) {
		repository.delete(e);
	}
	
	public Employee consultar(Employee e) {
		return repository.findOne(e.getId());
	}
	
	public Employee consultar(Long id) {
		return repository.findOne(id);
	}
	
	public List<Employee> listar() {
		return repository.findAll();
	}

	
	// Queries customizadas
	
	public List<Employee> listarPorIdade(int idade) {
		return repository.findEmployeesByAge(idade);
	}
	
	public List<Employee> listarPorNome(String nome) {
		return repository.findEmployeesByName(nome);
	}
	
	public List<Employee> listarPorIdadeMaiorQue(int idade) {
		return repository.findEmployeesByAgeGreaterThan(idade);
	}
	
	public List<Employee> listarPorIdadeEntre(int de, int ate) {
		return repository.findEmployeesBetweenAge(de, ate);
	}
	
	
}
