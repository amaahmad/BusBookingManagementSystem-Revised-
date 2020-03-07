package com.cg.java.tests;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.java.Exception.EmpException;
import com.cg.java.config.ProjectConfig;
import com.cg.java.dao.EmpDao;
import com.cg.java.dao.EmpDaoImpl;
import com.cg.java.services.EmpService;
import com.cg.java.services.EmpServiceImpl;


public class TestLayers010 {
		public static void main(String args[]){
			ConfigurableApplicationContext ctx= new AnnotationConfigApplicationContext(ProjectConfig.class);
			System.out.println("********");
			EmpService ser1=ctx.getBean("empService", EmpService.class);
			EmpService ser2=ctx.getBean("empService", EmpService.class);
			try {
				System.out.println(ser1.getEmpList());
				System.out.println("dao1: " + ser1.hashCode());
				System.out.println("dao2: " + ser2.hashCode());
			} catch (EmpException e) {
				
				e.printStackTrace();
			}
			ctx.close();
		}

		
}
