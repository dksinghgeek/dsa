package com.ggn.probs.dsa.ds.graph;

public class Prism {
	static int I = Integer.MAX_VALUE;
	public void prismAlgo(int[][] cost , int n) {
		int min = Integer.MAX_VALUE;
		int u = 0; int v = 0;int i; int j;int k = 0;
		int[] near = {0,I,I,I,I,I,I,I};
		int[][] t = new int[2][n-2];
		
		
		for(i = 1 ; i < n ; i++) {
			for(j = i ; j < n ; j++) {
				if(cost[i][j] < min) {
					min = cost[i][j];
					u = i;
					v = j;
				}
			}
		}
		
		System.out.println("Min : " + min + " (u : " + u + " v : " + v + ")");
		t[0][0] = u; t[1][0] = v;
		near[u] = 0 ; near[v] = 0;
		
		for (i = 1; i < n; i++) {
			if (near[i] != 0) {
				if (cost[i][u] < cost[i][v]) {
					near[i] = u;
				} else {
					near[i] = v;
				}
			}
		}
		
//		for (i = 0; i < n; i++) {
//			System.out.print(" " + near[i]);
//		}
		
		for (i = 1; i < n-2; i++) {
			min = I;
			for (j = 1; j < n; j++) {
					if (near[j] != 0 && cost[j][near[j]] < min) {
						min = cost[j][near[j]];
						k = j;
					}
			}
			
			t[0][i] = k; t[1][i] = near[k];
			near[k] = 0;
			
//			System.out.println();
//			for (i = 0; i < n; i++) {
//				System.out.print(" " + near[i]);
//			}
			
			for(j = 1; j < n ; j++) {
				if(near[j] != 0 && cost[j][k] < cost[j][near[j]]) {
					near[j] = k;
				}
			}
		}
		
			for(j = 0 ; j < n-2 ; j++) {
				System.out.println(" (" +  t[0][j] + ", " + t[1][j] +")");
			}

	}

	public static void main(String[] args) {
		
		int[][] cost =  {
            {I, I, I, I, I, I, I, I},
            {I, I, 25, I, I, I, 5, I},
            {I, 25, I, 12, I, I, I, 10},
            {I, I, 12, I, 8, I, I, I},
            {I, I, I, 8, I, 16, I, 14},
            {I, I, I, I, 16, I, 20, 18},
            {I, 5, I, I, I, 20, I, I},
            {I, I, 10, I, 14, 18, I, I},
    };
		
		Prism op = new Prism();
		op.prismAlgo(cost, 8);
	}

}
