package com.ggn.probs.algo.dp.subsquences;

import java.util.Arrays;

public class LongestCommonSubsequenceMemoization {
	private static int[][] t = new int[1001][1001];

	public int LCS(char[] X, char[] Y, int m, int n) {
		if (m == 0 || n == 0)
			return 0;

		if (t[m][n] != -1)
			return t[m][n];

		if (X[m - 1] == Y[n - 1]) {
			t[m][n] = 1 + LCS(X, Y, m - 1, n - 1);
			return t[m][n];
		} else {
			t[m][n] = Math.max(LCS(X, Y, m - 1, n), LCS(X, Y, m, n - 1));
			return t[m][n];
		}
	}

	public static void main(String[] args) {
		LongestCommonSubsequenceMemoization op = new LongestCommonSubsequenceMemoization();

		char[] X = { 'a', 'c', 'f', 'g', 'z' };
		char[] Y = { 'a', 'f', 'z' };

		Arrays.stream(t).forEach(row -> Arrays.fill(row, -1));
		
		op.LCS(X, Y, X.length, Y.length);
		System.out.println(t[X.length][Y.length]);
	}

}
