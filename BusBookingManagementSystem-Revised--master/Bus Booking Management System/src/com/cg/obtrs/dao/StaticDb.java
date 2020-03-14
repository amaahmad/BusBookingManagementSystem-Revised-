package com.cg.obtrs.dao;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cg.obtrs.dto.BookingDTO;
import com.cg.obtrs.dto.BusDTO;

import com.cg.obtrs.dto.AdminDTO;

import com.cg.obtrs.dto.CustomerDTO;

public class StaticDb 
{
 static public ArrayList<CustomerDTO> custList = new ArrayList<>();
 static public Map<Integer,BusDTO> busList = new HashMap<>(); 
 static public ArrayList<AdminDTO> adminList=new ArrayList<>();
 static public Map<Integer, BookingDTO> bookingList = new HashMap<>();
 static public ArrayList<BookingDTO> detailsList= new ArrayList<>();
 
 
//Pre-populated Bus List Data
 static{
		busList.put(111, new BusDTO(111,"Delhi","Lucknow", LocalDateTime.of(2020, 03, 10, 5, 30), LocalDateTime.of(2020, 03, 10, 5, 30),"Volvo",35,900.0F,"16(B)",11));
		busList.put(140, new BusDTO(140,"Delhi","Lucknow", LocalDateTime.of(2020, 03, 10, 5, 30), LocalDateTime.of(2020, 03, 10, 5, 30),"AC BUS",40,950.0F,"16(B)",11));
		busList.put(120, new BusDTO(120,"Mumbai","Pune",LocalDateTime.of(2020, 03, 10, 5, 30), LocalDateTime.of(2020, 03, 10, 5, 30),"AC Bus",40,1200.0F,"17(F)", 4));
		busList.put(109, new BusDTO(109,"Ahemdabad","Gandhinagar",LocalDateTime.of(2020, 03, 10, 5, 30), LocalDateTime.of(2020, 03, 10, 5, 30),"Non-AC Bus",44,1050.0F,"18(G)", 0));
		busList.put(112, new BusDTO(112,"Talawade","Ahmednagar",LocalDateTime.of(2020, 03, 10, 5, 30), LocalDateTime.of(2020, 03, 10, 5, 30),"Double-Decker",47,500.0F,"02(B)", 12));
	}
 
//Pre-populated Customer List Data
static{
	custList.add(new CustomerDTO("Amaan Ahmad",7894561235L,"amaan.ahmad7@gmail.com",1231,"amaahmad","amaan123"));
	custList.add(new CustomerDTO("Yash Bhatia",7984651324L,"yash.bhatia@gmail.com",1241,"ybhatia","y@$hbhatia"));
	custList.add(new CustomerDTO("Shivani Sharma",7964581325L,"shivani.sharma@gmail.com",1272,"ssharma","shivani1235"));


}
static { 

	bookingList.put(100003,new BookingDTO(111,new String[] {"Amaan","Rohan","Rohit","Aman","Ram"},5,5445));
	bookingList.put(100005,new BookingDTO(111,new String[] {"Yash","Rohan","Rohit","Aman","Ram", "Neelesh"}, 6,4567));
	bookingList.put(100007,new BookingDTO(120,new String[] {"Shivani","Rohan","Rohit","Aman"},4,4567));
	bookingList.put(100034,new BookingDTO(112,new String[] {"Sumit","Rohan","Rohit","Aman","Ram"}, 5,4500));
	bookingList.put(100053,new BookingDTO(112,new String[] {"Shivam","Rohan","Rohit","Aman"}, 4,5000));
}
public static ArrayList<CustomerDTO> getCustList() {
	return custList;
}
public static void setCustList(ArrayList<CustomerDTO> custList) {
	StaticDb.custList = custList;
}
public static Map<Integer, BusDTO> getBusList() {
	return busList;
}
public static void setBusList(Map<Integer, BusDTO> busList) {
	StaticDb.busList = busList;
}
public static ArrayList<AdminDTO> getAdminList() {
	return adminList;
}
public static void setAdminList(ArrayList<AdminDTO> adminList) {
	StaticDb.adminList = adminList;
}
public static Map<Integer, BookingDTO> getBookingList() {
	return bookingList;
}
public static void setBookingList(Map<Integer, BookingDTO> bookingList) {
	StaticDb.bookingList = bookingList;
}

}



 
