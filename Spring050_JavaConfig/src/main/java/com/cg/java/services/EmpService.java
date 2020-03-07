package com.cg.java.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.java.Exception.EmpException;
import com.cg.java.dao.EmpDao;
import com.cg.java.dto.EmployeeDTO;

public interface EmpService {
	public List<EmployeeDTO> getEmpList() throws EmpException;
	public void setEmpdao(EmpDao empdao);

}
