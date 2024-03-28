package com.ggn.probs.design.patterns.strategy;

public class PaymentSystem {
	private PaymentStrategy paymentStrategy;
	
	public void processOrder(Order order) {
		paymentStrategy.pay(order.getAmount());
	}

	public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
		this.paymentStrategy = paymentStrategy;
	}
}
