package com.cg.java.dao;


import java.util.List;
import com.cg.java.Exception.EmpException;
import com.cg.java.dto.*;


public interface EmpDao {
		
	public List<EmployeeDTO> getEmpList() throws EmpException;
}
