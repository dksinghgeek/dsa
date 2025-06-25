package com.ggn.probs.dsa.ds.recursion;

public class GenerateAllBalancedParentheses {

	public void solve(String op, int open, int close) {
		if(open == 0 && close == 0) {
			System.out.println(op);
			return;
		}
		
		if(open != 0) {
			String op1 = op + "(";
			solve(op1, open-1, close);
		}
		
		if(close > open) {
			String op1 = op + ")";
			solve(op1, open, close-1);
		}
	}

	public static void main(String[] args) {
		GenerateAllBalancedParentheses ob = new GenerateAllBalancedParentheses();
		String op = "";
		int open = 4;
		int close = 4;
		
		ob.solve(op, open, close);
	}

}
