package com.ggn.probs.design.patterns.state;

public class UnlockState extends State {

	public UnlockState(Phone phone) {
		super(phone);
	}

	@Override
	public void clickPowerButtone() {
		phone.setState(new LockState(phone));
		phone.unlock();
	}

}
