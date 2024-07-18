package com.ggn.probs.algo.backtracking;

import java.util.Arrays;

public class mColoring {
	static int V = 4;
	static int M = 3;
	static int[] colors = new int[V];
	
	private static boolean mColorSolution(int[][] graph, int v) {
		if(V == v)
			return true;
		
		for(int c = 0; c < M; c++) {
			if(isSafe(v, c, graph)) {
				colors[v] = c;
				if(mColorSolution(graph, v+1)) {
					return true;
				}
				colors[v] = -1;
			}
		}
		
		return false;
	}


	private static boolean isSafe(int v, int c, int[][] graph) {
		for(int i = 0 ; i < V ; i++) {
			if(graph[v][i] == 1 && colors[i] == c) {
				return false;
			}
		}
		return true;
	}

	public static void printGraph() {
		for(int i = 0 ; i < V; i++) {
			System.out.print(colors[i] + " ");
		}
	}

	public static void main(String[] args) {
		int graph[][] = {
	            { 0, 1, 1, 1 },
	            { 1, 0, 1, 0 },
	            { 1, 1, 0, 1 },
	            { 1, 0, 1, 0 },
	        };
		Arrays.fill(colors, -1);
		
		if(mColorSolution(graph, 0)) {
			printGraph();
		}
		
	}
}
