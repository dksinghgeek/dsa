package com.ggn.probs.design.patterns.facade;

public class Demo {
	public static void main(String[] args) {
		BookingFacede facade = new BookingFacede();
		facade.bookMovieTicket(new User("Raj", "dks@gmail.com", "6366596080"), "Movie", 10.0);
	}

}
