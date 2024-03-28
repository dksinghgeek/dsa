package com.ggn.probs.design.patterns.adapter;

import java.util.ArrayList;
import java.util.List;

public class Demo {

	public static void main(String[] args) {
		List<Insurance> list = new ArrayList<Insurance>();
		
		TataInsurance tataInsurance = new TataInsurance();
		HDFCInsurance hdfcInsurance = new HDFCInsurance();
		
		list.add(tataInsurance);
		list.add(new HDFCInsuranceAdapter(hdfcInsurance));
		
		System.out.println(list);

	}

}
