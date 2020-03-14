package com.cg.obtrs.dao;

import com.cg.obtrs.dto.AdminDTO;

public interface AdminDAO {

	 public String adminSignUp(AdminDTO adminDto);
	    
	 public String adminLoginIn(String userName, String password);
	 
	 
}
