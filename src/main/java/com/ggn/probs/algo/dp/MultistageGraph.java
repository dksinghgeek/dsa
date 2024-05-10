package com.ggn.probs.algo.dp;

public class MultistageGraph {
	
	public void multistageGraphAlgo(int[][] graph, int n, int stage) {
		int[] d = new int[n];
		int[] p = new int[n];
		int[] cost = new int[n];
		int k = 0;
		
		
		cost[n-1] = 0;
		for(int i = n-2; i >= 1 ; i--) {
			int min = Integer.MAX_VALUE;
			
			for(int j = i+1 ; j < n; j++) {
				if(graph[i][j] != 0 && graph[i][j]+cost[j] < min) {
					min = graph[i][j]+cost[j];
					d[i] = j;
				}
			}
			cost[i] = min;
		}
		
		p[1] = 1; p[stage] = n;
		
		for(int i = 2; i < stage ; i++) {
			p[i] = d[p[i-1]];
		}
		
		for(int i = 1 ; i <= stage; i++) {
			System.out.print(" " + p[i]);
		}
	}

	public static void main(String[] args) {
		int[][] graph = new int[][] { 
			{0,0,0,0,0,0,0,0},
            { 0, 1, 2, 5, 0, 0, 0, 0 }, 
            { 0, 0, 0, 0, 4, 11, 0, 0 }, 
            { 0, 0, 0, 0, 9, 5, 16, 0 }, 
            { 0, 0, 0, 0, 0, 0, 2, 0 }, 
            { 0, 0, 0, 0, 0, 0, 0, 18 }, 
            { 0, 0, 0, 0, 0, 0, 0, 13 }, 
            { 0, 0, 0, 0, 0, 0, 0, 2 } 
        }; 
        
        MultistageGraph op = new MultistageGraph();
        op.multistageGraphAlgo(graph, 8, 4);
		
	}

}
