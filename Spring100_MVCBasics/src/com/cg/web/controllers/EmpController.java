package com.cg.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//  http://localhost:8090/Spring100_MVCBasics/empService/home.do
@Controller
@RequestMapping("/empService")
public class EmpController {
	
			@RequestMapping("/home.do")
			public String getHomePage(){
				return "/WEB-INF/jsps/Home.jsp" ;
				
				
			}
}
