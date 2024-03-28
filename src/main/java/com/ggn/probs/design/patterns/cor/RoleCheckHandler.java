package com.ggn.probs.design.patterns.cor;

public class RoleCheckHandler extends Handler {

	@Override
	public boolean handler(String user, String password) {
		if("admin".equals(user)) {
			System.out.println("Load admin pasge");
			return true;
		}
		
		System.out.println("Load default page");
		return handleNext(user, password);
	}

}
