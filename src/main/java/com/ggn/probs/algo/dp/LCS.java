package com.ggn.probs.algo.dp;

public class LCS {
	
	//Using recursion
//	public int LCS(char[] T, char[] P, int i, int j) {
//		if(i == T.length || P.length == j) {
//			return 0;
//		}
//		
//		if(T[i] == P[j]) {
//			return 1 + LCS(T, P, i+1, j+1); 
//		} else {
//			return Math.max(LCS(T, P, i+1, j), LCS(T, P, i, j+1));
//		}
//	}
	
	//Using DP
	public int LCS(char[] Q, char[] P, int n, int m) {
		int[][] T = new int[n+1][m+1];
		
		for(int i = 0; i < n+1; i++) {
			for(int j = 0; j < m+1; j++) {
				if(i == 0 || j == 0) {
					T[i][j] = 0;
				}
			}
		}
		
		for(int i = 1; i < n+1; i++) {
			for(int j = 1; j < m+1; j++) {
				if(Q[i - 1] == P[j - 1]) {
					T[i][j] = 1 + T[i-1][j-1];
				} else {
					T[i][j] = Math.max(T[i-1][j], T[i][j-1]);
				}
			}
		}
		
		findChars(T, n, m, Q);
		System.out.println();
		return T[n][m];
	}
	
	public void findChars(int[][] T, int n, int m, char[] Q) {
		int i = n; int j = m;
		
		while(i > 0 && j > 0) {
			if(T[i-1][j] != T[i][j] || T[i][j-1] != T[i][j]) {
				System.out.print(Q[i-1] + " ");
				i = i - 1;
				j = j - 1;
			} else {
				if(T[i-1][j] == T[i][j]) {
					i = i - 1;
				} else if(T[i][j-1] == T[i][j]) {
					j = j - 1;
				}
			}
		}
	}

	public static void main(String[] args) {
		LCS op = new LCS();
		String T = "AGGTAB";
        String P = "GXTXAYB";
//		System.out.println(op.LCS(T.toCharArray(), P.toCharArray(), 0, 0));
        System.out.println(op.LCS(T.toCharArray(), P.toCharArray(), T.length(), P.length()));
	}

}
