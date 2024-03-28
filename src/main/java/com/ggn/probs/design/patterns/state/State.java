package com.ggn.probs.design.patterns.state;

public abstract class State {
	protected Phone phone;
	
	public State(Phone phone) {
		this.phone = phone;
	}
	
	public abstract void clickPowerButtone();
}
