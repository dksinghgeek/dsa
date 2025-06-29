package com.ggn.probs.algo.dp.Knapsack;


//o-1
public class Knapsack {
	
	public void kanpsackAlgo(int[] P, int[] wt, int W, int n) {
		int[][] K = new int[n+1][W+1];
		
		for(int i = 0 ; i <= n ; i++) {
			for(int w = 0 ; w <= W ; w++) {
				if(i == 0 || w == 0) {
					K[i][w] = 0;
				} else if(wt[i] <= w) {
					K[i][w] = Math.max(K[i-1][w], P[i] + K[i-1][w-wt[i]]);
				} else {
					K[i][w] = K[i-1][w];
				}
			}
		}
		
		print(K, n, W, wt);
	}

	private void print(int[][] k, int n, int W, int[] wt) {
		int i = n;
		int j = W;
		
		while(i > 0 && j > 0) {
			if(k[i][j] == k[i-1][j]) {
				System.out.print("0->");
				i--;
			}else {
				System.out.print("1->");
				j = j-wt[i];
				i--;
			}
		}
	}

	public static void main(String[] args) {
		int[] P = {0,1,2,5,6};
		int[] wt = {0,2,3,4,5};
		
		Knapsack op = new Knapsack();
		op.kanpsackAlgo(P, wt, 8, 4);
//		[[0, 0, 0, 0, 0, 0, 0, 0, 0], 
//		 [0, 0, 1, 1, 1, 1, 1, 1, 1], 
//		 [0, 0, 1, 2, 2, 3, 3, 3, 3], 
//		 [0, 0, 1, 2, 5, 5, 6, 7, 7], 
//		 [0, 0, 1, 2, 5, 6, 6, 7, 8]]
//		
	}

}
