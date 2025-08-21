package com.ggn.probs.algo.dp.subsquences;

public class SequencePatternMatching {

	public static void main(String[] args) {
		SequencePatternMatching op = new SequencePatternMatching();

		char[] X = { 'A', 'X', 'Y' };
		char[] Y = { 'A', 'D', 'X', 'C', 'P', 'Y' };

		if (op.seqPatternMatching(X, Y, X.length, Y.length)) {
			System.out.println("Matched");
		} else {
			System.out.println("Unmatched");
		}
	}

	private boolean seqPatternMatching(char[] X, char[] Y, int m, int n) {
		int length = LCS(X, Y, m, n);

		if (Math.min(X.length, Y.length) == length)
			return true;
		return false;
	}

	private int LCS(char[] X, char[] Y, int m, int n) {
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
				if (X[i - 1] == Y[j - 1]) {
					t[i][j] = 1 + t[i - 1][j - 1];
				} else {
					t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
				}
			}
		}

		return t[m][n];
	}

}
