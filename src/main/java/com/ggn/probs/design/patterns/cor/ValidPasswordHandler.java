package com.ggn.probs.design.patterns.cor;

public class ValidPasswordHandler extends Handler {
	private Database database;
	
	public ValidPasswordHandler(Database database) {
		this.database = database;
	}

	@Override
	public boolean handler(String user, String password) {
		if(!database.isValidPassword(user, password)) {
			System.out.println("Wrong password!");
			return false;
		}
		
		return handleNext(user, password);
	}

}
