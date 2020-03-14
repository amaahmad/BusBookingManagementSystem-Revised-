package com.cg.obtrs.dto;

public class CustomerDTO 
{
 private  String custName;
 private  Long custPhoneNumber;
 private String custEmail;
 private Integer custID;
 private String custUserName;
 private String custPassword;
 private String feedBack;
 private int rating;
 private int Age;

 public String getFeedBack() {
	return feedBack;
}
public void setFeedBack(String feedBack) {
	this.feedBack = feedBack;
}
public int getRating() {
	return rating;
}
public void setRating(int rating) {
	this.rating = rating;
}
public int getAge() {
	return Age;
}
public void setAge(int age) {
	Age = age;
}
public String getCustUserName() {
	return custUserName;
}
public void setCustUserName(String custUserName) {
	this.custUserName = custUserName;
}
public String getCustPassword() {
	return custPassword;
}
public void setCustPassword(String custPassword) {
	this.custPassword = custPassword;
}
public CustomerDTO(String custName, Long custPhoneNumber, String custEmail, Integer custID, String custUserName, String custPassword) 
 {
		super();
		this.custName = custName;
		this.custPhoneNumber = custPhoneNumber;
		this.custEmail = custEmail;
		this.custID = custID;
		this.custUserName = custUserName;
		this.custPassword = custPassword;
 }
  public CustomerDTO()
  {
	  
  }
public String getCustName() {
	return custName;
}
public void setCustName(String custName) {
	this.custName = custName;
}
public Long getCustPhoneNumber() {
	return custPhoneNumber;
}
public void setCustPhoneNumber(Long custPhoneNumber) {
	this.custPhoneNumber = custPhoneNumber;
}
public String getCustEmail() {
	return custEmail;
}
public void setCustEmail(String custEmail) {
	this.custEmail = custEmail;
}
public Integer getCustID() {
	return custID;
}
public void setCustID(Integer custID) {
	this.custID = custID;
}
@Override
public String toString() {
	return "[custName=" + custName + ", custPhoneNumber=" + custPhoneNumber + ", custEmail=" + custEmail
			+ ", custID=" + custID + "]";
}

}
