package com.cg.obtrs.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookingDTO {
	private int busId;
    private String passengerNames[];
	private Integer seatsBooked;
	private float totalFare;
	
	public BookingDTO()
	{
		
	}
	
	
	public BookingDTO(int busId, String[] passengerNames, Integer seatsBooked, float totalFare) {
		super();
		this.busId = busId;
		this.passengerNames = passengerNames;
		this.seatsBooked = seatsBooked;
		this.totalFare =totalFare;
	}


	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	
	public Integer getSeatsBooked() {
		return seatsBooked;
	}
	
	public void setSeatsBooked(Integer seatsBooked) {
		this.seatsBooked = seatsBooked;
	}
	public String[] getPassengerNames() {
		return passengerNames;
	}
	public void setPassengerNames(String[] passengerNames) {
		this.passengerNames = passengerNames;
	}


	public float getTotalFare() {
		return totalFare;
	}


	public void setTotalFare(float totalFare) {
		this.totalFare = totalFare;
	}
	

}