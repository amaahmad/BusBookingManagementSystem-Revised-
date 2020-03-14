package com.cg.obtrs.service;

import java.util.List;

import com.cg.obtrs.dao.BookingDAO;
import com.cg.obtrs.dao.BookingDAOImpl;
import com.cg.obtrs.exception.CustomException;

public class BookingServiceImpl implements BookingService{
      BookingDAO bookingdao = new BookingDAOImpl();
      
	@Override
	public String bookSeat(List<String>passengerNames,int age, long cardNumber , byte cardCvv, int busId, float totalFare) throws CustomException {
		  return bookingdao.bookSeat(passengerNames,age,cardNumber,cardCvv, busId,totalFare);
	}

	@Override
	public String generateTicket(int busId, int bookingId) throws CustomException {
		  return bookingdao.generateTicket(busId, bookingId);
	}

	@Override
	public float displayFare(int age, int busId) throws CustomException {
		
		return bookingdao.displayFare(age, busId);
	}

	@Override
	public String cancelBooking(int bookingId, int busId) throws CustomException {
		
		return bookingdao.cancelBooking(bookingId, busId);
	}

	@Override
	public float refundMoney(int bookingId) throws CustomException {
		return bookingdao.refundMoney(bookingId);
	}

}
