package com.ggn.probs.algo.dp;


//Floyd Warshall
public class AllPairShortestPath {
	
	public void allPairShortestPathAlgo(int[][] graph, int n) {
		for(int k = 0 ; k < n ; k++) {
			for(int i = 0 ; i < n ; i++) {
				for(int j = 0 ; j < n ; j++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]);
				}
			}
		}
	}

	public static void main(String[] args) {
		AllPairShortestPath op = new AllPairShortestPath();
	}

}
