package com.ggn.probs.design.patterns.facade;

import java.util.Random;

public class Ticket {
	private String movie;
	private double amount;
	private Random random = new Random();
	
	public Ticket(String movie, double amount) {
		this.setMovie(movie);
		this.setAmount(amount);
	}

	public String getId() {
		return String.valueOf(random.nextInt());
	}

	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
