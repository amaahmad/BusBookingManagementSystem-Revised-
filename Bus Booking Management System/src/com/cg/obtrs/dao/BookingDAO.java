package com.cg.obtrs.dao;

import java.util.List;

import com.cg.obtrs.dto.BookingDTO;
import com.cg.obtrs.dto.BusDTO;
import com.cg.obtrs.dto.CustomerDTO;
import com.cg.obtrs.exception.CustomException;

public interface BookingDAO 
{
   public String generateTicket(int busId, int bookingId) throws CustomException;
//
	public float refundMoney(int bookingId) throws CustomException;
//   
     public float displayFare(int age, int busId) throws CustomException;
//   
//   public String checkSeatAvailability(BookingDTO booking, BusDTO bus) throws CustomException;
//   
     public String cancelBooking(int bookingId, int busId) throws CustomException;
//   
   public String bookSeat(List<String> passengerNames,int age,long cardNumber,byte cardCvv, int busId, float totalFare) throws CustomException;
   
} 
