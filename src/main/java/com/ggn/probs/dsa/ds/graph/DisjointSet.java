package com.ggn.probs.dsa.ds.graph;

public class DisjointSet {
	public void union(int[] S, int u, int v) {
		if(S[v] < S[u]) {
			S[v] = S[v]+S[u];
			S[u] = v;
		} else {
			S[u] = S[v]+S[u];;
			S[v] = u; 
		}
	}
	
	public int find(int[] S, int u) {
		int x = u;
		int v;
		
		while(S[x] > 0) {
			x = S[x];
		}
		
		while(u != x) {
			v = S[u];
			S[u] = x;
			u = v;
		}
		
		return x;
	}

	public static void main(String[] args) {

	}

}
