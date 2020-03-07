package com.cg.java.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.java.Exception.EmpException;
import com.cg.java.dto.EmployeeDTO;


@Component("empDaoImpl")
public class EmpDaoImpl implements EmpDao{

	public List<EmployeeDTO> getEmpList() throws EmpException {
			List<EmployeeDTO> empList=new ArrayList<EmployeeDTO>();
			empList.add(new EmployeeDTO(101, "Yash", 30000));
			empList.add(new EmployeeDTO(102, "Sumit", 35000));
			empList.add(new EmployeeDTO(103, "Zoya", 40000));
			return empList;
		
	}

}
