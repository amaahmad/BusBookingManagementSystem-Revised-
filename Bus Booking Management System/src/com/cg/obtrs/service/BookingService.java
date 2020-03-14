package com.cg.obtrs.service;

import java.util.List;

import com.cg.obtrs.exception.CustomException;

public interface BookingService 
{
	public String bookSeat(List<String> passengerNames,int age,long cardNumber,byte cardCvv, int busId, float totalFare) throws CustomException;
	
	public String generateTicket(int busId, int bookingId) throws CustomException;
	
	public float displayFare(int age, int busId) throws CustomException;
	
	public String cancelBooking(int bookingId, int busId) throws CustomException;
	
	public float refundMoney(int bookingId) throws CustomException;
	
}
