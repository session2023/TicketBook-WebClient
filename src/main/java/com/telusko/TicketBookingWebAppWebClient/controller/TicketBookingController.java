package com.telusko.TicketBookingWebAppWebClient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.telusko.TicketBookingWebAppWebClient.requestrespond.Passenger;
import com.telusko.TicketBookingWebAppWebClient.requestrespond.Ticket;
import com.telusko.TicketBookingWebAppWebClient.service.BookingTicketService;



@Controller
public class TicketBookingController {
	
	@Autowired
	private BookingTicketService service;
	
	

	@PostMapping("/book-ticket")
	public String getTicketBooking(@ModelAttribute Passenger passenger, Model model) {
		
		
		
		Ticket ticket = service.bookTicket(passenger);
		model.addAttribute("ticket", ticket.getTicketNumber());
		
		return "index";
		
		
	}
	
	@GetMapping("/form")
	public String getForm(Model map) {
		
		map.addAttribute("passenger", new Passenger());
		
		return "index";
	}
	
	
	@GetMapping("/ticket")
	public String getTheTicketForm(Model map) {
		
		map.addAttribute("ticket", new Ticket());
		
		return "ticket-form";
	}
	
	@GetMapping("/get-ticket")
	public String getTheTicketDetails(@RequestParam("ticketNumber") Integer ticketNumber, Model model) {
		
		Ticket ticket = service.getFullTicketInfo(ticketNumber);
		model.addAttribute("ticket", ticket);
		return "ticket-info";
		
	}

}
