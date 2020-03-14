package com.cg.obtrs.dto;

public class AdminDTO {
	private  String adminName;
	 private  Long adminPhoneNumber;
	 private String adminEmail;
	 private Integer adminID;
	 private String adminUserName;
	 private String adminPassword;
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public Long getAdminPhoneNumber() {
		return adminPhoneNumber;
	}
	public void setAdminPhoneNumber(Long adminPhoneNumber) {
		this.adminPhoneNumber = adminPhoneNumber;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public Integer getAdminID() {
		return adminID;
	}
	public void setAdminID(Integer adminID) {
		this.adminID = adminID;
	}
	public String getAdminUserName() {
		return adminUserName;
	}
	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	@Override
	public String toString() {
		return "AdminDTO [adminName=" + adminName + ", adminPhoneNumber=" + adminPhoneNumber + ", adminEmail="
				+ adminEmail + ", adminID=" + adminID + ", adminUserName=" + adminUserName + ", adminPassword="
				+ adminPassword + "]";
	}
	public AdminDTO(String adminName, Long adminPhoneNumber, String adminEmail, Integer adminID, String adminUserName,
			String adminPassword) {
		super();
		this.adminName = adminName;
		this.adminPhoneNumber = adminPhoneNumber;
		this.adminEmail = adminEmail;
		this.adminID = adminID;
		this.adminUserName = adminUserName;
		this.adminPassword = adminPassword;
	}
	 
	
}

