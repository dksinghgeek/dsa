package com.ggn.probs.design.patterns.state;

public class LockState extends State {

	public LockState(Phone phone) {
		super(phone);
	}

	@Override
	public void clickPowerButtone() {
		phone.setState(new UnlockState(phone));
		phone.lock();
	}

}
