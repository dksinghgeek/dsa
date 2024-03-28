package com.ggn.probs.design.patterns.state;

public class Phone {
	private State state;
	
	public Phone() {
		state = new OffState(this);
	}

	public void setState(State state) {
		this.state = state;
	}
	
	public void unlock() {
		System.out.println("Unlock phone");
		
	}

	public void off() {
		System.out.println("Off phone");
		
	}

	public void lock() {
		System.out.println("Lock Phone");
		
	}
	
	public void clickPower() {
		state.clickPowerButtone();
	}

}
