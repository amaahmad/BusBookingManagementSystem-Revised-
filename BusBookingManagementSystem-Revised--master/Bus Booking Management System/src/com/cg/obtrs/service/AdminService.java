package com.cg.obtrs.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.cg.obtrs.dto.AdminDTO;
import com.cg.obtrs.dto.BookingDTO;
import com.cg.obtrs.exception.CustomException;

public interface AdminService {
	
	 public String adminSignUp(AdminDTO adminDto);
	    
	 public String adminLoginIn(String userName, String password);
	 
	 public String addBusOrRoute(int busId, String sourceStation, String destinationStation,LocalDateTime boardingTime, LocalDateTime dropTime, String busType, Integer totalSeats,
				Float fare);
	 
	 public ArrayList<BookingDTO> generateReport();
	 
	 public String cancelBooking(int busId, int bookingId) throws CustomException;
	 
	 public String updateSourceStation(int busId,String sourceStation);
	 
	 public String updateDestinationStation(int busId,String destinationStation);
	 
	 public String updateBoardingTime(int busId,LocalDateTime boardingTime);
	 
	 public String updateDropTime(int busId,LocalDateTime dropTime);
	 
	 public String updateBustype(int busId,String busType);
	 
	 public String updateTotalSeats(int busId,int totalSeats);
	 
	 public String updateFare(int busId,Float fare);

}
