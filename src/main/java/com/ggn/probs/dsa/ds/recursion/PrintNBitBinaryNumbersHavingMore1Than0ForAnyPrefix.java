package com.ggn.probs.dsa.ds.recursion;

public class PrintNBitBinaryNumbersHavingMore1Than0ForAnyPrefix {

	public static void main(String[] args) {
		PrintNBitBinaryNumbersHavingMore1Than0ForAnyPrefix ob = new PrintNBitBinaryNumbersHavingMore1Than0ForAnyPrefix();
		int N = 3;
		int one = 0;
		int zero = 0;
		String op = "";

		ob.solve(one, zero, N, op);
	}

	private void solve(int one, int zero, int n, String op) {
		if (n == 0) {
			System.out.println(op);
			return;
		}

		String op1 = op + "1";
		solve(one + 1, zero, n - 1, op1);

		if (one > zero) {
			String op2 = op + "0";
			solve(one, zero + 1, n - 1, op2);
		}
	}

}
