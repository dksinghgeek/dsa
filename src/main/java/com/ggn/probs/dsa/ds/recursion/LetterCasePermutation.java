package com.ggn.probs.dsa.ds.recursion;

public class LetterCasePermutation {
	
	public void solve(String ip, String op) {
		if(ip.length() == 0) {
			System.out.println(op);
			return;
		}
		
		if((ip.charAt(0) >= 'a' && ip.charAt(0) <= 'z') || (ip.charAt(0) >= 'A' && ip.charAt(0) <= 'Z')) {
			String op1 = op + ip.substring(0,1).toLowerCase();
			String op2 = op + ip.substring(0, 1).toUpperCase();
			ip = ip.substring(1);
			solve(ip, op1);
			solve(ip, op2);
		} else {
			String op1 = op + ip.charAt(0);
			ip = ip.substring(1);
			solve(ip, op1);
		}
	}

	public static void main(String[] args) {
		LetterCasePermutation ob = new LetterCasePermutation();
		ob.solve("a1b2", "");
	}

}
