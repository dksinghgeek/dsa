package com.ggn.probs.design.patterns.facade;

public class BookingFacede {
	public void bookMovieTicket(User user, String movie, double amount) {
		UserSystem userSystem = new UserSystem();
		PaymentSystem paymentSystem = new PaymentSystem();
		TicketSystem ticketSystem = new TicketSystem();
		NotificationSystem notificationSystem = new NotificationSystem();
		
		boolean isValidUser = userSystem.isValidUser(user);
		if(isValidUser) {
			Ticket ticket = ticketSystem.createTicket(movie, amount);
			paymentSystem.pay(ticket);
			
			notificationSystem.sendMail(user.getEmail());
			notificationSystem.sendSms(user.getPhone());
		}
	}
}	
