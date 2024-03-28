package com.ggn.probs.dsa.ds.recursion;

public class TailRecursion {
	public void tail(int n) {
		if(n > 0) {
			System.out.print(n + " ");
			tail(n-1);
		}
	}

	public static void main(String[] args) {
		TailRecursion tailRecursion = new TailRecursion();
		tailRecursion.tail(3);
	}

}
