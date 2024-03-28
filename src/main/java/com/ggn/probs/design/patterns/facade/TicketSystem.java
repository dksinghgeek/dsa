package com.ggn.probs.design.patterns.facade;

public class TicketSystem {	
	public Ticket createTicket(String movie, double amount) {
		Ticket ticket = new Ticket(movie, amount);
		System.out.println("Ticket created");
		return ticket;
	}
}
