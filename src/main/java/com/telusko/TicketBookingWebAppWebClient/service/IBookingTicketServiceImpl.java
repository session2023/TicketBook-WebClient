package com.telusko.TicketBookingWebAppWebClient.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.telusko.TicketBookingWebAppWebClient.requestrespond.Passenger;
import com.telusko.TicketBookingWebAppWebClient.requestrespond.Ticket;

@Service
public class IBookingTicketServiceImpl implements BookingTicketService {
	
	private String BOOKING_URL = "http://localhost:8484/TicketBookingApp/api/book-ticket/getTicketNumber";
	private String GET_URL = "http://localhost:8484/TicketBookingApp/api/book-ticket/getTicket/{ticketNumber}";

	@Override
	public Ticket bookTicket(Passenger passenger) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<Ticket> responseEntity = restTemplate.postForEntity(BOOKING_URL, passenger, Ticket.class);
		
		
	
		return responseEntity.getBody();
	}

	@Override
	public Ticket getFullTicketInfo(Integer ticketNumber) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		Ticket ticket = restTemplate.getForObject(GET_URL, Ticket.class, ticketNumber);
		
		return ticket;
	}
	
	

}
