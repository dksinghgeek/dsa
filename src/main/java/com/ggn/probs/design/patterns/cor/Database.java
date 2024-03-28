package com.ggn.probs.design.patterns.cor;

import java.util.AbstractMap;
import java.util.Map;

public class Database {
	private Map<String, String> users = Map.ofEntries(new AbstractMap.SimpleEntry<String, String>("admin", "admin"),
			new AbstractMap.SimpleEntry<String, String>("user", "password"));
	
	public boolean isValidUser(String user, String password) {
		return users.containsKey(user);
	}
	
	public boolean isValidPassword(String user, String password) {
		return users.get(user).equals(password);
	}

}
