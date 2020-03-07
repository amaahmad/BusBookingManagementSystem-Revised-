package com.cg.java.dto;

import org.springframework.stereotype.Component;

@Component("empDTO")
public class EmployeeDTO {
		private int empNo;
		private String empName;
		private float empSal;
		
		public EmployeeDTO(int empNo, String empName, float empSal) {
			super();
			this.empNo = empNo;
			this.empName = empName;
			this.empSal = empSal;
		}
		public int getEmpNo() {
			return empNo;
		}
		public void setEmpNo(int empNo) {
			this.empNo = empNo;
		}
		public String getEmpName() {
			return empName;
		}
		public void setEmpName(String empName) {
			this.empName = empName;
		}
		public float getEmpSal() {
			return empSal;
		}
		public void setEmpSal(float empSal) {
			this.empSal = empSal;
		}
		@Override
		public String toString() {
			return "EmployeeDTO [empNo=" + empNo + ", empName=" + empName + ", empSal=" + empSal + "]";
		}
		
		
}
