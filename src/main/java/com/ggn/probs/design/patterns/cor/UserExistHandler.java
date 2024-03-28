package com.ggn.probs.design.patterns.cor;

public class UserExistHandler extends Handler {
	private Database database;
	
	public UserExistHandler(Database database) {
		this.database = database;
	}

	@Override
	public boolean handler(String user, String password) {
		if(!database.isValidUser(user, password)) {
			System.out.println("User is not registered");
			System.out.println("Sign up to our app now!");
			return false;
		}
		
		return handleNext(user, password);
	}

}
