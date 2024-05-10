package com.ggn.probs.algo.dp;

public class Fibonacci {
	public int fib(int n) {
		if( n <= 1)
			return n;
		
		int[] fib = new int[n+1];
		fib[0] = 0;
		fib[1] = 1;
		
		for(int i = 2 ; i <= n ; i++) {
			fib[i] = fib[i-1]+fib[i-2];
		}
		
		return fib[n];
	}

	public static void main(String[] args) {
		Fibonacci op = new Fibonacci();
		System.out.println(op.fib(5));
	}

}
