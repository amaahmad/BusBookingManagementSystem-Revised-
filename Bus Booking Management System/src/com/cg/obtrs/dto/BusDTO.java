package com.cg.obtrs.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class BusDTO 
{
  private int busId;
  private String sourceStation;
  private String destinationStation;
  private LocalDateTime boardingTime;
  private LocalDateTime dropTime;
  private String busType;
  private Integer totalSeats;
  private Float fare;
  private String SeatNo;
  private int seatsBooked;
  
public BusDTO(int busId, String sourceStation, String destinationStation,LocalDateTime boardingTime, LocalDateTime dropTime, String busType, Integer totalSeats,
		Float fare, String seatNo, int seatsBooked) {
	super();
	this.busId=busId;
	this.sourceStation = sourceStation;
	this.destinationStation = destinationStation;
	this.busType = busType;
	this.fare = fare;
	this.SeatNo = seatNo;
	this.totalSeats=totalSeats;
	this.boardingTime = boardingTime;
	this.dropTime = dropTime;
	this.seatsBooked= seatsBooked;
}
public BusDTO()
{
	super();
}

public int getSeatsBooked() {
	return seatsBooked;
}
public void setSeatsBooked(int seatsBooked) {
	this.seatsBooked = seatsBooked;
}

public String getSourceStation() {
	return sourceStation;
}
public void setSourceStation(String sourceStation) {
	this.sourceStation = sourceStation;
}
public String getDestinationStation() {
	return destinationStation;
}
public void setDestinationStation(String destinationStation) {
	this.destinationStation = destinationStation;
}
public String getBusType() {
	return busType;
}
public void setBusType(String busType) {
	this.busType = busType;
}
public Integer getTotalSeats() {
	return totalSeats;
}
public void setTotalSeats(Integer totalSeats) {
	this.totalSeats = totalSeats;
}
public Float getFare() {
	return fare;
}
public void setFare(Float fare) {
	this.fare = fare;
}
public String getSeatNo() {
	return SeatNo;
}
public void setSeatNo(String seatNo) {
	SeatNo = seatNo;
}

public LocalDateTime getBoardingTime() {
	return boardingTime;
}
public void setBoardingTime(LocalDateTime boardingTime) {
	this.boardingTime = boardingTime;
}
public LocalDateTime getDropTime() {
	return dropTime;
}
public void setDropTime(LocalDateTime dropTime) {
	this.dropTime = dropTime;
}

public int getBusId() {
	return busId;
}
public void setBusId(int busId) {
	this.busId = busId;
}
@Override
public String toString() {
	return "busId=" + busId + ", sourceStation=" + sourceStation + ", destinationStation=" + destinationStation
			+ ", boardingTime=" + boardingTime + ", dropTime=" + dropTime + ", busType=" + busType + ", totalSeats="
			+ totalSeats + ", fare=" + fare + "\n\n";
}



}

 

