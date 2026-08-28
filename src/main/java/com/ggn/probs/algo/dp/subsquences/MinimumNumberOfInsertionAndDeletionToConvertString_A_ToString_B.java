package com.ggn.probs.algo.dp.subsquences;

public class MinimumNumberOfInsertionAndDeletionToConvertString_A_ToString_B {

	public static void main(String[] args) {
		MinimumNumberOfInsertionAndDeletionToConvertString_A_ToString_B op = new MinimumNumberOfInsertionAndDeletionToConvertString_A_ToString_B();

		char[] X = { 'h', 'e', 'a', 'p' };
		char[] Y = { 'p', 'e', 'a' };

		int lcs = LCS(X, Y, X.length, Y.length);

		if (X.length > Y.length) {
			System.out.println("Deletion : " + (X.length - lcs));
			System.out.println("Insertion : " + (Y.length - lcs));
		} else {
			System.out.println("Deletion : " + (Y.length - lcs));
			System.out.println("Insertion : " + (X.length - lcs));
		}

	}

	private static int LCS(char[] X, char[] Y, int m, int n) {
		int[][] t = new int[m + 1][n + 1];

		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				if (i == 0) {
					t[i][j] = 0;
				}

				if (j == 0) {
					t[i][j] = 0;
				}
			}
		}
		
		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if(X[i-1] == Y[j-1]) {
					t[i][j] = 1 + t[i-1][j-1];
				} else {
					t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
				}
			}
		}

		return t[m][n];
	}

}
