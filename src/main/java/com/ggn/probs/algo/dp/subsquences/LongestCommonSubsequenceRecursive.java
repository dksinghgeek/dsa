package com.ggn.probs.algo.dp.subsquences;

public class LongestCommonSubsequenceRecursive {
	public int LCS(char[] X, char[] Y, int n, int m) {
		if (n == 0 || m == 0) {
			return 0;
		}

		if (X[n - 1] == Y[m - 1]) {
			return 1 + LCS(X, Y, n - 1, m - 1);
		} else {
			return Math.max(LCS(X, Y, n - 1, m), LCS(X, Y, n, m - 1));
		}
	}

	public static void main(String[] args) {
		LongestCommonSubsequenceRecursive op = new LongestCommonSubsequenceRecursive();

		char[] X = { 'a', 'c', 'f', 'g', 'z' };
		char[] Y = { 'a', 'f', 'z' };

		System.out.println(op.LCS(X, Y, X.length, Y.length));
	}

}
