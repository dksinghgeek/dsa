package com.ggn.probs.design.patterns.adapter;

public class HDFCInsuranceAdapter implements Insurance {
	private HDFCInsurance hdfcInsurance;
	
	public HDFCInsuranceAdapter(HDFCInsurance hdfcInsurance) {
		this.hdfcInsurance = hdfcInsurance;
	}

	public void processClaim(Pdf document) {
		Word word = new Word(document.getName(), document.getContent());
		hdfcInsurance.processClaim(word);
	}

}
