package com.cg.obtrs.dao;

import java.util.List;

import com.cg.obtrs.dto.BusDTO;
import com.cg.obtrs.dto.CustomerDTO;
import com.cg.obtrs.exception.CustomException;

public interface CustomerDAO 
{
    public String customerSignUp(String name, long phoneNumber, String email, int custId, String userName, String password) throws CustomException;
    
    public String customerLoginIn(String userName, String password) throws CustomException;
    
    public boolean changePassword(String custEmail , String currentPassword, String newPassword) throws CustomException;
	
    public List<BusDTO> searchBus(String sourceStation, String destinationStation) throws CustomException;
    
    public Integer checkSeatAvailability(int busId) throws CustomException; 
}
