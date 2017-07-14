package com.edn.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.edn.service.EmployeeService;

public class SpringDataTesteMetodosCustomizados {

	public static void main(String[] args) {
		
		// Recuperando contexto do spring (service)
		System.out.println("Recuperando o servico");
		EmployeeService service = getEmployeeService();
		
		// Lista original
		System.out.println();
		System.out.println("lista original");
		service.listar().forEach(e -> System.out.println(e.toString()));
		
		// Lista por idade
		System.out.println();
		System.out.println("Listando por idade...");
		service.listarPorIdade(1).forEach(e -> System.out.println(e.toString()));
		
		// Lista por nome
		System.out.println();
		System.out.println("Listando por nome...");
		service.listarPorNome("Ricardo").forEach(e -> System.out.println(e.toString()));
		
		// Listar por idade maior que
		System.out.println();
		System.out.println("Listando por idade maior que...");
		service.listarPorIdadeMaiorQue(44).forEach(e -> System.out.println(e.toString()));
		
		// Listar por idade entre
		System.out.println();
		System.out.println("Listando por idade entre...");
		service.listarPorIdadeEntre(20, 30).forEach(e -> System.out.println(e.toString()));
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
