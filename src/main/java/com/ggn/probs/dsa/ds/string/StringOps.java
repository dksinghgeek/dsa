package com.ggn.probs.dsa.ds.string;

public class StringOps {

	public void duplicateInStringsUsingBitswise(String input) {
		int H = 0; int X = 0;
		
		for(int i = 0 ; i < input.length() ; i++) {
			X = 1;
			X = X << input.charAt(i) - 'a';
			
			if((H & X) > 0) {
				System.out.println("Duplicate : " + input.charAt(i));
			} else {
				H  = H|X;
			}
		}
	}
	
	public static void main(String[] args) {
      String input = "findings";
      StringOps op = new StringOps();
      op.duplicateInStringsUsingBitswise(input);
	}

}
