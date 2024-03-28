package com.ggn.probs.design.patterns.adapter;

public class HDFCInsurance {
	public void processClaim(Word document) {
		System.out.println("Processed claim " + document.getName() + " " + document.getContent());
	}
}
