package com.ggn.probs.design.patterns.strategy;

public class Demo {

	public static void main(String[] args) {
		PaymentSystem paymentSystem = new PaymentSystem();
		PaymentStrategy paymentStrategy = new PaymentByCreditCard();
		
		Order order = new Order();
		order.setAmount(10.0);
		paymentSystem.setPaymentStrategy(paymentStrategy);;
		paymentSystem.processOrder(order);
	}

}
