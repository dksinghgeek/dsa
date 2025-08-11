package com.ggn.probs.algo.dp.subsquences;

public class LongestCommonSubstring {
	public int LCS(char[] X, char[] Y, int m, int n) {
		int lcs = Integer.MIN_VALUE;
		int[][] t = new int[m + 1][n + 1];

		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				if (j == 0) {
					t[i][j] = 0;
				}

				if (i == 0) {
					t[i][j] = 0;
				}
			}
		}

		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (X[i - 1] == Y[j - 1]) {
					t[i][j] = 1 + t[i - 1][j - 1];
					lcs = Math.max(t[i][j], lcs);
				} else {
					t[i][j] = 0;
				}
			}
		}

		return lcs;
	}

	public static void main(String[] args) {
		LongestCommonSubstring op = new LongestCommonSubstring();

		char[] X = { 'a', 'c', 'f', 'g', 'z' };
		char[] Y = { 'a', 'c', 'e' };

		System.out.println(op.LCS(X, Y, X.length, Y.length));

	}

}
