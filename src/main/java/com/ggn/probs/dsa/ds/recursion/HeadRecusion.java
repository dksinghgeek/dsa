package com.ggn.probs.dsa.ds.recursion;

public class HeadRecusion {
	public void head(int n) {
		if(n > 0) {
			head(n - 1);
			System.out.print(n + " ");
		}
	}

	public static void main(String[] args) {
		HeadRecusion headRecusion = new HeadRecusion();
		headRecusion.head(3);
	}

}
