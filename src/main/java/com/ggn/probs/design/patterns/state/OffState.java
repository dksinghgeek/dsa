package com.ggn.probs.design.patterns.state;

public class OffState extends State {
	
	public OffState(Phone phone) {
		super(phone);
	}

	@Override
	public void clickPowerButtone() {
		phone.setState(new UnlockState(phone));
		phone.off();
	}

}
