package com.cg.obtrs.dao;

import java.util.ArrayList;
import java.util.List;

import com.cg.obtrs.dto.BookingDTO;
import com.cg.obtrs.dto.BusDTO;
import com.cg.obtrs.dto.CustomerDTO;
import com.cg.obtrs.exception.CustomException;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
    public String customerSignUp(String name, long phoneNumber, String email, int custId, String userName, String password) throws CustomException
   {
		StaticDb.custList.add(new CustomerDTO(name,phoneNumber,email,custId,userName,password));
		return "User Signup Successfull......!";
	}

	@Override
	public String customerLoginIn(String userName, String password) throws CustomException {
		int flag = 0;
		for (CustomerDTO cust : StaticDb.custList) {
			if (cust.getCustUserName().equals(userName) && cust.getCustPassword().equals(password)) {
				flag = 1;
				break;
			}

		}
		if (flag == 1)
			return "*************************** Login Successful ***************************\n\n"+"************************OPTIONS**************************";
		else
		 throw new CustomException("Username or Password is incorrect");
	}

	@Override
	public boolean changePassword(String custEmail, String currentPassword, String newPassword) throws CustomException {
		int flag = 0;
		for (int i = 0; i < StaticDb.custList.size(); i++) {
			if (custEmail.equals(StaticDb.custList.get(i).getCustEmail())) {
				StaticDb.custList.get(i).setCustPassword(newPassword);
				flag = 1;
			}
		}
		if (flag == 1)
			return true;
		else
			throw new CustomException("Cannot change Password");
	}

	@Override
	public List<BusDTO> searchBus(String sourceStation, String destinationStation) throws CustomException 
	{
		List<BusDTO> searchList = new ArrayList<>();
		for (BusDTO bus : StaticDb.busList.values())
		{
			if(bus.getSourceStation().equalsIgnoreCase(sourceStation) && bus.getDestinationStation().equalsIgnoreCase(destinationStation))
			{
				 searchList.add(bus);
			}
		}
           if(searchList.isEmpty())
        	  throw new CustomException("No buses Found");
		return searchList;
	}
	 public Integer checkSeatAvailability(int busId) throws CustomException 
	 {
		   BusDTO busDto = StaticDb.busList.get(busId);
           int totalSeats = busDto.getTotalSeats();
           int seatsBooked = busDto.getSeatsBooked();
           int seatsAvailable = totalSeats-seatsBooked;
           return seatsAvailable;
	 }
}
