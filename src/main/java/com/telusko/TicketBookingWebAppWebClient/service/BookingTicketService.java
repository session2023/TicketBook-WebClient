package com.telusko.TicketBookingWebAppWebClient.service;

import com.telusko.TicketBookingWebAppWebClient.requestrespond.Passenger;
import com.telusko.TicketBookingWebAppWebClient.requestrespond.Ticket;

public interface BookingTicketService {
	
	public Ticket bookTicket(Passenger passenger);
	public Ticket getFullTicketInfo(Integer ticketNumber);

}
