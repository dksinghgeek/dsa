package com.ggn.probs.design.patterns.facade;

public class NotificationSystem {
	public void sendMail(String mail) {
		System.out.println("Mail sent : " + mail);
	}
	
	public void sendSms(String phone) {
		System.out.println("SMS sent : " + phone);
	}
}
