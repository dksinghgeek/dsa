package com.ggn.probs.design.patterns.facade;

public class PaymentSystem {
	public void pay(Ticket ticket) {
		System.out.println("Payment complete : " + ticket.getAmount());
	}
}
