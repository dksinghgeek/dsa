package com.ggn.probs.dsa.ds.recursion;

public class TOHOperations {
	private static int count = 0;

	public static void TOH(int n, int A, int B, int C) {
		if (n == 0)
			return;
		count++;
		if (n == 1) {
			System.out.println("Move disc from " + A + " to " + C);
			return;
		}

		TOH(n - 1, A, C, B);
		System.out.println("Move disc from " + A + " to " + C);
		TOH(n - 1, B, A, C);
	}

	public static void main(String[] args) {
		TOH(20, 1, 2, 3);
		System.out.println("Count : " + count);
	}

}
