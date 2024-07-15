package com.ggn.probs.dsa.ds.recursion;

public class TOHOperations {
	public static void TOH(int n, int A, int B, int C) {
		if(n > 0) {
			TOH(n-1, A, C, B);
			System.out.println("Move disc from " + A + " to " + C);
			TOH(n-1, B, A, C);
		}
	}

	public static void main(String[] args) {
		TOH(3, 1, 2, 3);
	}

}
