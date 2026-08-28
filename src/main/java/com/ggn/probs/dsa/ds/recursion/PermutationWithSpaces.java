package com.ggn.probs.dsa.ds.recursion;

public class PermutationWithSpaces {
	
	public void solve(String ip, String op) {
		if(ip.length() == 0) {
			System.out.println(op);
			return;
		}
		
		String op1 = op + "_" + ip.charAt(0);
		String op2 = op + ip.charAt(0);
		
		ip = ip.substring(1);
		
		solve(ip, op1);
		solve(ip, op2);
	}

	public static void main(String[] args) {
		PermutationWithSpaces ob = new PermutationWithSpaces();
		String ip = "BC";
		String op = "A";
		
		ob.solve(ip, op);
	}

}
