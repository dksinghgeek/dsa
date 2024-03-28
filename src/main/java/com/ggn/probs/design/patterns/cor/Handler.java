package com.ggn.probs.design.patterns.cor;

public abstract class Handler {
	private Handler next;
	
	public Handler setNextHandler(Handler next) {
		this.next = next;
		return next;
	}
	
	public abstract boolean handler(String user, String password);
	
	protected boolean handleNext(String user, String password) {
		if(next == null)
			return true;
		
		return next.handleNext(user, password);
	}
}
