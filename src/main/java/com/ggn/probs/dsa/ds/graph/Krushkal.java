package com.ggn.probs.dsa.ds.graph;

public class Krushkal {
	int[] included = {0,0,0,0,0,0,0,0,0};
	int[][] t = new int[2][6];
	int[] set = new int[8];
	
	public void union(int u, int v) {
		if(set[v] < set[u]) {
			set[v] = set[v]+set[u];
			set[u] = v;
		} else {
			set[u] = set[v]+set[u];;
			set[v] = u; 
		}
	}
	
	public int find( int u) {
		int x = u;
		int v;
		
		while(set[x] > 0) {
			x = set[x];
		}
		
		while(u != x) {
			v = set[u];
			set[u] = x;
			u = v;
		}
		
		return x;
	}
	
	public void krushkalAlgo(int[][] edges) {
		int n = 7;
		int i = 0 ; int j = 0; int e = 9; int u = 0 ; int v = 0; int k = 0;
		
		while(i < n - 1) {
			int min = Integer.MAX_VALUE;
			for(j = 0 ; j < e ; j++) {
				if(included[j] == 0 && edges[2][j] < min) {
					u = edges[0][j];
					v = edges[1][j];
					min = edges[2][j];
					k = j;
				}
			}
			
			if(find(u) != find(v)) {
				t[0][i] = u;
				t[1][i] = v;
				union(find(u), find(v));
				i++;
			}
			included[k] = 1;
		}
		
		for(j = 0 ; j < n-2 ; j++) {
			System.out.println(" (" +  t[0][j] + ", " + t[1][j] +")");
		}
	}

	public static void main(String[] args) {
		int[][] edges = {{ 1, 1,  2,  2, 3,  4,  4,  5,  5},
                { 2, 6,  3,  7, 4,  5,  7,  6,  7},
                {25, 5, 12, 10, 8, 16, 14, 20, 18}};
		
		Krushkal op = new Krushkal();
		op.krushkalAlgo(edges);
	}

}
