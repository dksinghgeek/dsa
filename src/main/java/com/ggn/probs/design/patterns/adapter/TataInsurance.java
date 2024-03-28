package com.ggn.probs.design.patterns.adapter;

public class TataInsurance implements Insurance{
	public void processClaim(Pdf document) {
		System.out.println("Processed claim " + document.getName() + " " + document.getContent());
	}
}
