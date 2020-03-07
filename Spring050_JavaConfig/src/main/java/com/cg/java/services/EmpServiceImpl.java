package com.cg.java.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.java.Exception.EmpException;
import com.cg.java.dao.EmpDao;
import com.cg.java.dto.EmployeeDTO;


@Service("empService")
public class EmpServiceImpl implements EmpService {
		@Autowired
		private EmpDao empdao;
		
		public EmpDao getEmpdao() {
		return empdao;
		}

		public void setEmpdao(EmpDao empdao) {
			this.empdao = empdao;
		}

	public List<EmployeeDTO> getEmpList() throws EmpException {
		
		return empdao.getEmpList();
	}
	

}
