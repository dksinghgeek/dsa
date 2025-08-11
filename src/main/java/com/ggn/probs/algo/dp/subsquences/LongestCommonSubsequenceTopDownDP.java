package com.ggn.probs.algo.dp.subsquences;

public class LongestCommonSubsequenceTopDownDP {

	public int LCS(char[] X, char[] Y, int m, int n) {
		int[][] t = new int[m + 1][n + 1];

		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				if (j == 0) {
					t[i][j] = 0;
				}

				if (j == 0) {
					t[i][j] = 0;
				}
			}
		}

		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (X[i - 1] == Y[j - 1]) {
					t[i][j] = 1 + t[i-1][j-1];
				} else {
					t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
				}
			}
		}

		return t[m][n];
	}

	public static void main(String[] args) {
		LongestCommonSubsequenceTopDownDP op = new LongestCommonSubsequenceTopDownDP();

		char[] X = { 'a', 'c', 'f', 'g', 'z' };
		char[] Y = { 'a', 'f', 'z' };

		System.out.println(op.LCS(X, Y, X.length, Y.length));
	}

}
