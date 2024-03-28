package com.ggn.probs.design.patterns.cor;

public class Demo {

	public static void main(String[] args) {
		Database database = new Database();

		Handler handler = new UserExistHandler(database).setNextHandler(new ValidPasswordHandler(database))
				.setNextHandler(new RoleCheckHandler());
		
		AuthService authService = new AuthService(handler);
		authService.login("user", "password");

	}

}
