package com.ggn.probs.algo.dp;

public class TSP {
	static int n = 4;
	static int VISITED_ALL = (1 << n) - 1;
	static int[][] dp = new int[16][4];
	int dist[][] = {
	        {0,20,42,25},
	        {20,0,30,34},
	        {42,30,0,10},
	        {25,34,10,0}
	    };

	public int tsp(int mask, int pos) {
		if (mask == VISITED_ALL) {
			return dist[pos][0];
		}
		
		if(dp[mask][pos] != -1) {
			return dp[mask][pos];
		}
		
		int ans = Integer.MAX_VALUE;
		for(int city = 0; city < n; city++) {
			if((mask & (1 << city)) == 0) {
				int newAns = dist[pos][city] + tsp((mask | (1<<city)), city);
				ans = Math.min(ans, newAns);
			}
		}
		
		return dp[mask][pos] = ans;
	}

	public static void main(String[] args) {
		for(int i = 0 ; i < (1 << n); i++) {
			for(int j = 0 ; j < n ; j++) {
				dp[i][j] = -1;
			}
		}
		
		TSP op = new TSP();
		System.out.println(op.tsp(1, 0));
		
		System.out.println(1<<0);
	}

}
