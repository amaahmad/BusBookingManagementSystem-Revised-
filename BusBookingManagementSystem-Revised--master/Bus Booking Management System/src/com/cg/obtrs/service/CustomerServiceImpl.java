package com.cg.obtrs.service;

import java.util.List;

import com.cg.obtrs.dao.CustomerDAO;
import com.cg.obtrs.dao.CustomerDAOImpl;
import com.cg.obtrs.dao.StaticDb;
import com.cg.obtrs.dto.BusDTO;
import com.cg.obtrs.dto.CustomerDTO;
import com.cg.obtrs.exception.CustomException;

public class CustomerServiceImpl implements CustomerService 
{
   CustomerDAO custDAO = new CustomerDAOImpl();
	@Override
    public String customerSignUp(String name, long phoneNumber, String email, int custId, String userName, String password) throws CustomException

	{
		return custDAO.customerSignUp(name, phoneNumber, email, custId, userName, password);
	}

	@Override
	public String customerLoginIn(String userName, String password) throws CustomException {
	
		return custDAO.customerLoginIn(userName, password);
	}

	@Override
	public boolean changePassword(String custEmail, String currentPassword, String newPassword) throws CustomException {
		int flag=0;
		for(int i=0;i<StaticDb.custList.size();i++)
		{
			if(custEmail.equals(StaticDb.custList.get(i).getCustEmail()))
			{
				 if(currentPassword.equals(StaticDb.custList.get(i).getCustPassword()))
				 {
					flag=1;
				 }
			}
		}
		if(flag==1)
			return custDAO.changePassword(custEmail, currentPassword,newPassword);
		else
			throw new CustomException("Sorry! Invalid Details");
	}

	@Override
	public String sendFeedback(String feedback, int rating) throws CustomException {
		// TODO Auto-generated method stub
		return null;
	}
	public List<BusDTO> searchBus(String sourceStation, String destinationStation) throws CustomException
	{
      return custDAO.searchBus(sourceStation, destinationStation);
	}

	@Override
	public Integer checkSeatAvailability(int busId) throws CustomException {
		
		return custDAO.checkSeatAvailability(busId);
	}
   
}
