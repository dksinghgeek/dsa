package com.ggn.probs.design.patterns.cor;

public class AuthService {
	private Handler handler;
	
	public AuthService(Handler handler) {
		this.handler = handler;
	}
	
	public boolean login(String user, String password) {
		if(handler.handler(user, password)) {
			System.out.println("Successful authentication");
			return true;
		}
		
		return false;
	}
}
