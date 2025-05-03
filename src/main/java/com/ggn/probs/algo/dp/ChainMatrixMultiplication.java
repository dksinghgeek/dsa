package com.ggn.probs.algo.dp;

public class ChainMatrixMultiplication {
	
	public void ChainMatrixMultiplicationAlgo(int[] p, int n) {
		int q = 0;
		int[][] T = new int[n][n];
		int[][] K = new int[n][n];
		
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				T[i][j] = 0;
				K[i][j] = 0;
			}
		}
		
		
		for(int d = 1; d < n - 1; d++) {
			for(int i = 1 ; i < n - d; i++) {
				int j = i + d;
				int min = Integer.MAX_VALUE;
				
				for(int k = i ; k <= j-1; k++) {
					q = T[i][k] + T[k+1][j] + p[i-1]*p[k]*p[j];
					if(q < min) {
						min = q;
						K[i][j]=k;
					}
				}
				T[i][j] = min;
			}
		}
		
		System.out.println("Result : " + T[1][n-1]);
	}

	public static void main(String[] args) {
		int[] p = {5,4,6,2,7};
		ChainMatrixMultiplication op = new ChainMatrixMultiplication();
		op.ChainMatrixMultiplicationAlgo(p, 5);
	}

}
