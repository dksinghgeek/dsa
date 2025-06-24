package com.ggn.probs.dsa.ds.recursion;

public class PermutationWithCaseChange {

	public void solve(String ip, String op) {
		if (ip.length() == 0) {
			System.out.println(op);
			return;
		}

		String op1 = op + ip.charAt(0);
		String op2 = op + ip.substring(0, 1).toUpperCase();

		ip = ip.substring(1);

		solve(ip, op1);
		solve(ip, op2);
	}

	public static void main(String[] args) {
		PermutationWithCaseChange ob = new PermutationWithCaseChange();
		ob.solve("ab", "");
	}

}
