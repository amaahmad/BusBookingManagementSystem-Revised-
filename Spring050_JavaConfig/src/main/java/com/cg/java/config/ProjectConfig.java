package com.cg.java.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.cg.java.dao.EmpDao;
import com.cg.java.dao.EmpDaoImpl;
import com.cg.java.services.EmpService;
import com.cg.java.services.EmpServiceImpl;

/*
 * 
 * @Configuration : Class Level. Declares a Class as Configuration Class.
 * @Bean : Method Level. Declares a method as a factory method.
 * 			A method responsible for creating, initializing an object is a factory method.
 * 
 * The @Lazy and @Scope annotations are also allowed on factory methods.
 * 
 * */

@Configuration

public class ProjectConfig {
	
	@Autowired
	ApplicationContext ctx;
			
	//Factory Method for EmpDaoImpl
	
	@Bean("empDao")
	@Lazy(true)
	@Scope("prototype")
	public EmpDao getEmpDao(){
		System.out.println("Bean created");
		return new EmpDaoImpl();
		
	}
	
	@Bean("empService")
	public EmpService getEmpService(){
	//	EmpDao dao=(EmpDao) ctx.getBean("empDao");
		EmpService service=new EmpServiceImpl();
		//service.setEmpdao(dao);
		return service;
		}
	}
