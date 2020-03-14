package com.cg.obtrs.dao;

import com.cg.obtrs.dto.AdminDTO;
import com.cg.obtrs.dto.CustomerDTO;

public class AdminDaoImpl implements AdminDAO {

	@Override
	public String adminSignUp(AdminDTO adminDto) {
		
		 StaticDb.adminList.add(adminDto);
	   	 return "Signup Successfull";
	}

	@Override
	public String adminLoginIn(String userName, String password) {
		
		int flag=0;
		for(AdminDTO admin : StaticDb.adminList)
		{
			if(admin.getAdminUserName().equals(userName) && admin.getAdminPassword().equals(password))
			{
			 flag=1;
			  break;
			}
			  
		}
		if(flag==1)
			return "Login Successful";
		else
			return "Username or password is incorrect";
	}
	
			
}
