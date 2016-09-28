package com.edn.service;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;

import com.edn.config.JpaConfig;
import com.edn.repository.EmployeeRepository;

@Transactional
@Import(JpaConfig.class)
@Configuration("mainBean")
@EnableJpaRepositories(basePackages = "com.edn.repository")
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	
	public void listAllEmployees() {
		repository.findAll().forEach(System.out::println);
	}

	
	public static void main(String[] args) throws URISyntaxException, Exception {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		
		try {
			
			ctx.register(EmployeeService.class);
			ctx.refresh();
			
			System.out.println("Loading spring context...");
			EmployeeService springDataTest = (EmployeeService) ctx.getBean("mainBean");
			
			springDataTest.listAllEmployees();
			
		} finally {
			ctx.close();
		}
		
	}
}
