package com.ggn.probs.algo.backtracking;

import java.util.Arrays;

public class HamiltonianCycle {
	static int V = 5;
	static int[] path = new int[V];
	
	public static boolean hamiltonCycleSolution(int[][] graph, int pos) {
		if(V == pos) {
			if(graph[path[pos-1]][0] == 1) {
				return true;
			} else {
				return false;
			}
		} else {
			for(int v = 1; v < V; v++) {
				if(isSafe(graph, v, pos)) {
					path[pos] = v;
					
					if(hamiltonCycleSolution(graph, pos+1))
						return true;
					
					path[pos] = -1;
				}
			}
		}
		
		return false;
	}

	private static boolean isSafe(int[][] graph, int v, int pos) {
		if(graph[path[pos-1]][v] == 0)
			return false;
		
		for(int i = 0 ; i < V; i++) {
			if(path[i] == v)
				return false;
		}
		
		return true;
	}

	public static void printPath() {
		for(int i = 0 ; i < V; i++) {
			System.out.print(path[i] + " ");
		}
		
		System.out.println(path[0] + " ");
	}
	
	public static void main(String[] args) {
		int[][] graph = {{0, 1, 0, 1, 0},
	            {1, 0, 1, 1, 1},
	            {0, 1, 0, 0, 1},
	            {1, 1, 0, 0, 1},
	            {0, 1, 1, 1, 0},
	        };
		
		Arrays.fill(path, -1);
		
		path[0] = 0;
		
		if(hamiltonCycleSolution(graph, 1)) {
			printPath();
		}


	}

}
