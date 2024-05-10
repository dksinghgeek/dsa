package com.ggn.probs.algo.greedy;

public class Dijkstra {
	static int I = Integer.MAX_VALUE;
	
	public int minDistance(int[] dist, boolean[] sptSet, int V) {
		int min = I;
		int min_index = 0;
		for(int i = 0 ; i < V ; i++) {
			if(sptSet[i] == false && dist[i] < min) {
				min = dist[i];
				min_index = i;
			}
		}
		
		return min_index;
	}
	
	public int[] dijkstraAlgo(int[][] graph, int src , int V) {
		int[] dist = new int[V];
		boolean[] sptSet = new boolean[V];
		
		for(int i = 0 ; i < V ; i++) {
			dist[i] = I;
			sptSet[i] = false;
		}
		
		dist[src] = 0;
		for(int i = 0 ; i < V-1 ; i++) {
			int u = minDistance(dist, sptSet, V);
			sptSet[u] = true;
			for(int j = 0 ; j < V ; j++) {
				if(!sptSet[j] && graph[u][j] != 0 && dist[u] != I && dist[u] + graph[u][j] < dist[j]) {
					dist[j] = dist[u] + graph[u][j];
				}
			}
		}
		return dist;
	}

	public static void main(String[] args) {
		
		int[][] graph = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
	                            { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
	                            { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
	                            { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
	                            { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
	                            { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
	                            { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
	                            { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
	                            { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
	                            
	    Dijkstra op = new Dijkstra();
	    int[] dist = op.dijkstraAlgo(graph, 0, 9);
	    
	    for(int i = 0 ; i < dist.length ; i++) {
	    	System.out.print(" " + dist[i]);
	    }

	}

}
