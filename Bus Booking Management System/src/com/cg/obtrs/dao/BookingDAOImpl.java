package com.cg.obtrs.dao;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import com.cg.obtrs.dto.BookingDTO;
import com.cg.obtrs.dto.BusDTO;
import com.cg.obtrs.exception.CustomException;

public class BookingDAOImpl implements BookingDAO {
	
	
	
//Function that books a seat that the passenger prefers. 
	public String bookSeat(List<String> passengerNames,int age, long cardNumber, byte cardCvv, int busId, float totalFare)
			throws CustomException {
		BookingDTO bookingDto = new BookingDTO();
		String namesArray[] = new String[passengerNames.size()];
		Random random = new Random();
		int bookingId = random.nextInt(10000);
		BusDTO busDto = StaticDb.busList.get(busId);
		for (int i = 0; i < passengerNames.size(); i++) {
			namesArray[i] = passengerNames.get(i);
		}
		bookingDto.setPassengerNames(namesArray);
		bookingDto.setSeatsBooked(passengerNames.size());
		bookingDto.setTotalFare(totalFare);
		busDto.setSeatsBooked(busDto.getSeatsBooked() + 1);
		StaticDb.bookingList.put(bookingId, bookingDto);
		return "Booking Confirmed" + " " + "Your Booking Id is=" + bookingId;
	}

	@Override
	/// Function to generateTicket
	public String generateTicket(int busId, int bookingId) throws CustomException {
		String names = "";
		BookingDTO bookingDto = StaticDb.bookingList.get(bookingId);
		String passengerNames[] = bookingDto.getPassengerNames();
		for (int i = 0; i < passengerNames.length; i++) {
			names = names + ", " + passengerNames[i];
		}
		int seatsBooked = bookingDto.getSeatsBooked();
		float fare = bookingDto.getTotalFare();
		BusDTO busDto = StaticDb.busList.get(busId);
		String source = busDto.getSourceStation();
		String destination = busDto.getDestinationStation();
		LocalDateTime boardingTime = busDto.getBoardingTime();
		LocalDateTime dropTime = busDto.getDropTime();
		return "Passenger Names=" + names + " " + "SeatsBooked=" + seatsBooked + " " + "Booking Id=" + bookingId + " "
				+ "Departure Station=" + source + " " + "Arrival station=" + destination + " " + "Fare=" + "Rs." + fare
				+ " " + "BoardingTime=" + boardingTime + " " + "Drop Time=" + dropTime;
	}

	//Function that refunds money in case of cancellation.
	public float refundMoney(int bookingId) throws CustomException
	{
		 BookingDTO bookingDto = StaticDb.bookingList.get(bookingId);
		 float totalFare = bookingDto.getTotalFare();
		 StaticDb.bookingList.remove(bookingId);
		 return totalFare;
	}
    
	//Function that displays the  Discounted Fare Amount 
	@Override
	public float displayFare(int age, int busId) throws CustomException {
		float busFare, discountedFare = 0;
		BusDTO busDto = StaticDb.busList.get(busId);
		busFare = busDto.getFare();
		if (age < 8) {
			float discount = (0.60f * busFare);
			discountedFare = busFare - discount;
		} else {
			discountedFare = busFare;
		}
		return discountedFare;
	}
	
//    //Function to check for seat availability in selected bus.
//	 public Integer checkSeatAvailability(int busId) throws CustomException 
//	 {
//		   BusDTO busDto = StaticDb.busList.get(busId);
//           int totalSeats = busDto.getTotalSeats();
//           int seatsBooked = busDto.getSeatsBooked();
//           int seatsAvailable = totalSeats-seatsBooked;
//           return seatsAvailable;
//	 }
	
	//Function to cancel the bus booking 
	@Override
	public String cancelBooking(int bookingId, int busId) throws CustomException {
		BusDTO busDto = StaticDb.busList.get(busId);
		busDto.setSeatsBooked(busDto.getSeatsBooked() - 1);
		BookingDTO bookingDto = StaticDb.bookingList.get(bookingId);
		bookingDto.setSeatsBooked(bookingDto.getSeatsBooked() - 1);
		return "Cancellation Successfull........\n" + "Refund has be initiated...........";
	}

	//

}
