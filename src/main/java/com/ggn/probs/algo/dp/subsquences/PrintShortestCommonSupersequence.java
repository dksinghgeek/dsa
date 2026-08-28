package com.ggn.probs.algo.dp.subsquences;

public class PrintShortestCommonSupersequence {

	public static void main(String[] args) {
		PrintShortestCommonSupersequence op = new PrintShortestCommonSupersequence();

		char[] X = { 'a', 'c', 'b', 'c', 'f' };
		char[] Y = { 'a', 'b', 'c', 'd', 'a', 'f', 'h', 'k' };

		int[][] t = LCS(X, Y, X.length, Y.length);

		String seq = printSequence(t, X, Y, X.length, Y.length);

		System.out.println(seq);
	}

	private static String printSequence(int[][] t, char[] X, char[] Y, int m, int n) {
		StringBuilder st = new StringBuilder();

		int i = m;
		int j = n;

		while (i > 0 && j > 0) {
			if (X[i - 1] == Y[j - 1]) {
				st.append(X[i - 1]);
				i--;
				j--;
			} else {
				if (t[i][j - 1] > t[i - 1][j]) {
					st.append(Y[j - 1]);
					j--;
				} else {
					st.append(X[i - 1]);
					i--;
				}
			}
		}

		while (i > 0) {
			st.append(X[i - 1]);
			i--;
		}

		while (j > 0) {
			st.append(Y[j - 1]);
			j--;
		}

		return String.valueOf(st.reverse());
	}

	private static int[][] LCS(char[] X, char[] Y, int m, int n) {
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

		return t;
	}

}
