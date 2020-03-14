package com.cg.obtrs.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map.Entry;

import com.cg.obtrs.dto.AdminDTO;
import com.cg.obtrs.dto.BookingDTO;
import com.cg.obtrs.dto.BusDTO;
import com.cg.obtrs.dto.CustomerDTO;
import com.cg.obtrs.exception.CustomException;

public class AdminDaoImpl implements AdminDAO {

	
	
	@Override
	public String adminSignUp(AdminDTO adminDto) {
		
		 StaticDb.adminList.add(adminDto);
	   	 return "Signup Successfull";
	}

	@Override
	public String adminLoginIn(String userName, String password) {
		
		int flag=0;
		for(AdminDTO admin : StaticDb.adminList)
		{
			if(admin.getAdminUserName().equals(userName) && admin.getAdminPassword().equals(password))
			{
			 flag=1;
			  break;
			}
			  
		}
		if(flag==1)
			return "Login Successful";
		else
			return "Username or password is incorrect";
	}
	
	public String addBusOrRoute(int busId, String sourceStation, String destinationStation,LocalDateTime boardingTime, LocalDateTime dropTime, String busType, Integer totalSeats,
			Float fare){
			BusDTO newBus= new BusDTO();
			newBus.setBusId(busId);
			newBus.setSourceStation(sourceStation);
			newBus.setDestinationStation(destinationStation);
			newBus.setBoardingTime(boardingTime);
			newBus.setDropTime(dropTime);
			newBus.setFare(fare);
			newBus.setBusType(busType);
			newBus.setTotalSeats(totalSeats);
			StaticDb.getBusList().put(newBus.getBusId(), newBus);
			return  "New Bus added [Bus ID : " + newBus.getBusId() + "]";
		
	}

	@Override
	public ArrayList<BookingDTO> generateReport() {
		if(StaticDb.busList.size()==0)
		{
			System.out.println("No records found");
		}
		else
		{
			for(Entry<Integer, BookingDTO> entry : StaticDb.bookingList.entrySet())
				StaticDb.detailsList.add(entry.getValue());
			
		}
		return StaticDb.detailsList;
	}

	@Override
	public String cancelBooking(int busId, int bookingId) throws CustomException {
		BusDTO busDto = StaticDb.busList.get(busId);
		busDto.setSeatsBooked(busDto.getSeatsBooked() - 1);
		BookingDTO bookingDto = StaticDb.bookingList.get(bookingId);
		bookingDto.setSeatsBooked(bookingDto.getSeatsBooked() - 1);
		return "Cancellation Successfull........\n" + "Refund has be initiated...........";
	}

	

	@Override
	public String updateSourceStation(int busId, String sourceStation) {
		BusDTO busDto= new BusDTO();
		busDto.setSourceStation(sourceStation);
		StaticDb.busList.replace(busId, busDto);
		return "Bus Details are updated successfully as per the Source Station";
	}

	@Override
	public String updateDestinationStation(int busId, String destinationStation) {
		BusDTO busDto= new BusDTO();
		busDto.setDestinationStation(destinationStation);
		StaticDb.busList.replace(busId, busDto);
		return "Bus Details are updated successfully as per the Destination Station";
	
	}

	@Override
	public String updateBoardingTime(int busId, LocalDateTime boardingTime) {
		BusDTO busDto= new BusDTO();
		busDto.setBoardingTime(boardingTime);
		StaticDb.busList.replace(busId, busDto);
		return "Bus Details are updated successfully as per the Boarding Time";
	}

	@Override
	public String updateDropTime(int busId, LocalDateTime dropTime) {
		BusDTO busDto= new BusDTO();
		busDto.setDropTime(dropTime);
		StaticDb.busList.replace(busId, busDto);
		return "Bus Details are updated successfully as per the Drop Time";
	}

	@Override
	public String updateBustype(int busId, String busType) {
		BusDTO busDto= new BusDTO();
		busDto.setBusType(busType);
		StaticDb.busList.replace(busId, busDto);
		return "Bus Details are updated successfully as per the Bus Type";
	}

	@Override
	public String updateTotalSeats(int busId, int totalSeats) {
		BusDTO busDto= new BusDTO();
		busDto.setTotalSeats(totalSeats);
		StaticDb.busList.replace(busId, busDto);
		return "Bus Details are updated successfully as per the number of seats";
	}

	@Override
	public String updateFare(int busId, Float fare) {
		BusDTO busDto= new BusDTO();
		busDto.setFare(fare);
		StaticDb.busList.replace(busId, busDto);
		return "Bus Details are updated successfully as per the bus Fare";
	
	}
}
