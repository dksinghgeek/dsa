package com.ggn.probs.dsa.ds.recursion;

public class Print {
	
	public void printForward(int n) {
		if(n == 1) {
			System.out.print(" " + n);
			return;
		} else {
			printForward(n-1);
			System.out.print(" " + n);
		}
	}
	
	public void printBackward(int n) {
		if(n == 1) {
			System.out.print(" " + n);
		} else {
			System.out.print(" " + n);
			printBackward(n - 1);
		}
	}

	public static void main(String[] args) {
		Print op = new Print();
		op.printForward(7);
		
		System.out.println();
		
		op.printBackward(7);
	}

}
