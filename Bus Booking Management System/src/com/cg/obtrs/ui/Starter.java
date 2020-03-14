package com.cg.obtrs.ui;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.cg.obtrs.exception.CustomException;
import com.cg.obtrs.service.BookingService;
import com.cg.obtrs.service.BookingServiceImpl;
import com.cg.obtrs.service.CustomerService;
import com.cg.obtrs.service.CustomerServiceImpl;

public class Starter {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean mainScreenFlag = true;
		CustomerService custService = new CustomerServiceImpl();
		BookingService bookingService = new BookingServiceImpl();
		while (mainScreenFlag) {
			System.out.println("************************ONLINE BUS TICKET RESERVATION SYSTEM***********************");
			System.out.println("1. To Continue as Admin");
			System.out.println("2. To Continue as User");
			int choice = input.nextInt();
			switch (choice) {
			case 1:
				break;
			case 2:
				System.out.println("1.User Sign Up");
				System.out.println("2.User Login in");
				int custChoice = input.nextInt();
				switch (custChoice) {
				case 1:
					System.out.println("Enter Username");
					String userName = input.next();
					System.out.println("Enter Password");
					String password = input.next();
					System.out.println("Enter your Name");
					String name = input.next();
					System.out.println("Enter Phone number");
					long phoneNo = input.nextLong();
					System.out.println("Enter Email ID");
					String email = input.next();
					Random random = new Random();
					int custId = random.nextInt(1000);
					try {
						System.out
								.println(custService.customerSignUp(name, phoneNo, email, custId, userName, password));
					} catch (CustomException e2) {

						System.out.println(e2.getMessage());
					}
					System.out.println("Sign In to Continue......");
				case 2:
					boolean loginScreenFlag = true;
					while (loginScreenFlag) {
						int loginFailureFlag = 0;
						System.out.println("Please Enter Username");
						userName = input.next();
						System.out.println("Please Enter Password");
						password = input.next();
						try {
							System.out.println(custService.customerLoginIn(userName, password));
							loginScreenFlag = false;
						} catch (CustomException e1) {
							loginFailureFlag = 1;
							System.out.println(e1.getMessage());
						}
						if (loginFailureFlag > 0) {
							System.out.println("Forgot Password? Confirm by pressing 1 or press 0 to Login again");
							int userPasswordChoice = input.nextInt();
							switch (userPasswordChoice) {
							case 1:
								System.out.println("Enter your email Id");
								email = input.next();
								System.out.println("Enter your userName");
								userName = input.next();
								break;

							case 0:
								loginScreenFlag = true;
							}
						}
						if (loginScreenFlag == false) {
							boolean passChangeFlag = true;
							while (passChangeFlag) {
								System.out.println("1.Change Password");
								System.out.println("2.Search for Bus");
								int loginChoice = input.nextInt();
								switch (loginChoice) {
								case 1:
									System.out.println("Enter Your EmailID");
									String customerEmail = input.next();
									System.out.println("Enter currentPassword");
									String currentPassword = input.next();
									System.out.println("Enter New Password");
									String newPassword = input.next();
									try {
										boolean flag = custService.changePassword(customerEmail, currentPassword,
												newPassword);
										if (flag == true) {
											System.out.println("Password changed successfully");
											System.out.println("You need to login again to continue.....");
											passChangeFlag = false;
											loginScreenFlag = true;
										}
									} catch (CustomException e) {
										System.out.println(e.getMessage());
									}

									break;
								case 2:
									boolean searchFlag = true;
									boolean sourceToDestinationFlag = true;
									while (sourceToDestinationFlag) {
										System.out.println("Enter Source Station");
										String sourceStation = input.next();
										System.out.println("Enter Destination Station");
										String destinationStation = input.next();
										searchFlag = true;
										while (searchFlag) {
											try {
												System.out.println(
														custService.searchBus(sourceStation, destinationStation));
												System.out.println("1.To continue with the booking....");
												System.out.println("2.Change Source ---> Destination");
												int busIdChoice = input.nextInt();
												switch (busIdChoice) {
												case 2:
													searchFlag = false;
													break;
												case 1:
													boolean busFarePageFlag = true;
													System.out.println("Please enter BusId");
													int busId = input.nextInt();
													while (busFarePageFlag) {
														System.out.println("1.Display Fare");
														System.out.println("2.Check Seat Availability");
														System.out.println("3.Go back to choose Bus");
														int seatChoice = input.nextInt();
														switch (seatChoice) {
														case 1:
															System.out.println("Enter your Age");
															int passengerAge = input.nextInt();
															System.out.println("Discount Fare for selected Bus=" + "Rs."
																	+ bookingService.displayFare(passengerAge, busId));
															searchFlag = false;
															sourceToDestinationFlag = false;
															break;
														case 2:
															boolean bookSeatFlag = true;
															System.out.println("Number of seats available ="
																	+ custService.checkSeatAvailability(busId));
															while (bookSeatFlag) {
																System.out.println("1. Book a Seat");
																System.out.println("2. Go back");
																searchFlag = false;
																int bookingChoice = input.nextInt();
																switch (bookingChoice) {
																case 1:
																	bookSeatFlag = false;
																	System.out.println("Enter Number of seats to book");
																	int noOfBookingSeats = input.nextInt();
																	float totalFare = 0;
																	int bookingId;
																	int age = 0;
																	ArrayList<String> passengerNames = new ArrayList<>();
																	for (int i = 1; i <= noOfBookingSeats; i++) {
																		System.out.println(i + "Passenger Name");
																		passengerNames.add(input.next());
																		System.out.println(i + "Passenger Age");
																		age = input.nextInt();
																		totalFare += bookingService.displayFare(age,
																				busId);
																	}
																	System.out
																			.println("Total Fare will be" + totalFare);
																	System.out.println(
																			"Enter Debit or Credit Card Number");
																	long cardNumber = input.nextLong();
																	System.out.println("Enter CVV");
																	byte cardCvv = input.nextByte();
																	System.out.println(bookingService.bookSeat(
																			passengerNames, age, cardNumber, cardCvv,
																			busId, totalFare));
																	System.out.println("1.Generate Ticket");
																	System.out.println("2.Cancel Booking");
																	int ticketChoice = input.nextInt();
																	switch (ticketChoice) {
																	case 1:
																		System.out.println("Enter your booking Id");
																		bookingId = input.nextInt();
																		System.out.println(bookingService
																				.generateTicket(busId, bookingId));
																		break;
																	case 2:
																		System.out.println("Enter Booking Id");
																		bookingId = input.nextInt();
																		System.out.println(bookingService
																				.cancelBooking(bookingId, busId));
																		System.out.println(
																				"Amount successfully refunded=" + "Rs."
																						+ bookingService.refundMoney(
																								bookingId));
																	}
																case 2:
																	busFarePageFlag = true;
																	bookSeatFlag = false;
																	break;

																}
															}
														case 3:
															busFarePageFlag = false;
															searchFlag = true;
														}
													}
												}
											} catch (CustomException e) {
												System.out.println(e);
											}
										}
									}
								}
							}
						}
					}

				}
			}
		}

	}
}
