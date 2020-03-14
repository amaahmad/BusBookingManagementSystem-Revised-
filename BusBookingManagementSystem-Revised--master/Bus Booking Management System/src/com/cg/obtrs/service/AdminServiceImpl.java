package com.cg.obtrs.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.cg.obtrs.dao.AdminDAO;
import com.cg.obtrs.dao.AdminDaoImpl;
import com.cg.obtrs.dto.AdminDTO;
import com.cg.obtrs.dto.BookingDTO;
import com.cg.obtrs.exception.CustomException;
//
public class AdminServiceImpl implements AdminService{

	AdminDAO adminDao= new AdminDaoImpl();
	@Override
	public String adminSignUp(AdminDTO adminDto) {
		
		return adminDao.adminSignUp(adminDto);
	}

	@Override
	public String adminLoginIn(String userName, String password) {
		
		return adminDao.adminLoginIn(userName, password);
	}

	@Override
	public String addBusOrRoute(int busId, String sourceStation, String destinationStation, LocalDateTime boardingTime,
			LocalDateTime dropTime, String busType, Integer totalSeats, Float fare) {
		
		return adminDao.addBusOrRoute(busId, sourceStation, destinationStation, boardingTime, dropTime, busType, totalSeats, fare);
	}

	@Override
	public ArrayList<BookingDTO> generateReport() {
		
		return adminDao.generateReport();
	}

	@Override
	public String cancelBooking(int busId, int bookingId) throws CustomException {
		
		return adminDao.cancelBooking(busId, bookingId);
	}

	@Override
	public String updateSourceStation(int busId, String sourceStation) {
	
		return adminDao.updateSourceStation(busId, sourceStation);
	}

	@Override
	public String updateDestinationStation(int busId, String destinationStation) {
		
		return adminDao.updateDestinationStation(busId, destinationStation);
	}

	@Override
	public String updateBoardingTime(int busId, LocalDateTime boardingTime) {
	
		return adminDao.updateBoardingTime(busId, boardingTime);
	}

	@Override
	public String updateDropTime(int busId, LocalDateTime dropTime) {
		
		return adminDao.updateDropTime(busId, dropTime);
	}

	@Override
	public String updateBustype(int busId, String busType) {
		
		return adminDao.updateBustype(busId, busType);
	}

	@Override
	public String updateTotalSeats(int busId, int totalSeats) {
		
		return adminDao.updateTotalSeats(busId, totalSeats);
	}

	@Override
	public String updateFare(int busId, Float fare) {
		
		return adminDao.updateFare(busId, fare);
	}

}
