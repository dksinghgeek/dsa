package com.ggn.probs.dsa.ds.matrix;

public class MatrixOps {

	public static void printDiagonal(int[][] mat, int n) {
		int i = 0;
		int j = 0;
		int c = 0;

		while ((j - i) >= 0 && j < n) {
			if (j - i == c) {
				System.out.print(j - i);
				System.out.println();

				if (i == (n - 1) - c) {
					c++;
					i = 0;
					j = c;
					continue;
				} else {
					for(int k = 0 ; k <= i ; k++) {
						System.out.print(" ");
					}
					
					i++;
					j++;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[][] mat = new int[4][4];
		printDiagonal(mat, 4);
		
	}

}
