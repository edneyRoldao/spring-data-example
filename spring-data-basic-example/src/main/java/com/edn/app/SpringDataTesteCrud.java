package com.edn.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.edn.model.Employee;
import com.edn.service.EmployeeService;

public class SpringDataTesteCrud {

	public static void main(String[] args) {
		
		// Recuperando contexto do spring (service)
		System.out.println("Recuperando o servico");
		EmployeeService service = getEmployeeService();
		
		// Teste inserir
		System.out.println();
		System.out.println("inserindo...");
		Employee emp = new Employee("Edney", 34);
		service.inserirOuAlterar(emp);

		// Teste consultar
		System.out.println();
		System.out.println("Consultando...");
		System.out.println( service.consultar(emp).toString() );
		
		// Teste alterar
		System.out.println();
		System.out.println("alterando...");
		emp.setName("Nadine");
		emp.setAge(14);
		service.inserirOuAlterar(emp);
		
		// Teste listar
		System.out.println();
		System.out.println("Listando...");
		service.listar().forEach(e -> System.out.println(e.toString()));
		
		// Teste remover
		System.out.println();
		System.out.println("removendo");
		service.remover(emp);
		System.out.println("Listando...");
		service.listar().forEach(e -> System.out.println(e.toString()));

		
		
	}
	
	private static EmployeeService getEmployeeService() {
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		
		EmployeeService service = null;
		
			ctx.register(EmployeeService.class);
			ctx.refresh();
			service = (EmployeeService) ctx.getBean("mainBean");
		
		return service;
	}
	
}
