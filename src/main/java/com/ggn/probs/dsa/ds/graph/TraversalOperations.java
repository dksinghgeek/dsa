package com.ggn.probs.dsa.ds.graph;

import com.ggn.probs.dsa.ds.queue.Queue;

public class TraversalOperations {
	private int[] isVisited = {0,0,0,0,0,0,0,0};
	
	public void BFS(int[][] G, int u, int V) {
		int[] isVisited = new int[V];
		Queue q = new Queue(20);
		
		for(int i = 1 ; i < V ; i++) {
			isVisited[i] = 0;
		}
		
		System.out.print(" " + u);
		if(isVisited[u] == 0) {
			isVisited[u] = 1;
		}
		q.enqueue(u);
		
		while(!q.isEmpty()) {
			u = q.dequeue();
			
			for(int v = 1 ; v < V ; v++) {
				if(G[u][v] == 1 && isVisited[v] == 0) {
					System.out.print(" " + v);
					isVisited[v] = 1;
					q.enqueue(v);
				}
			}
		}
	}
	
	public void DFS(int[][] G, int u, int V) {
		if(isVisited[u] == 0) {
			System.out.print(" " + u);
			isVisited[u] = 1;
			
			for(int v = 1 ; v < V ; v++) {
				if(G[u][v] == 1 && isVisited[v] == 0) {
					DFS(G, v, V);
				}
			}
		}
	}

	public static void main(String[] args) {
		TraversalOperations op = new TraversalOperations();
		 int[][] A = {{0, 0, 0, 0, 0, 0, 0, 0},
                 {0, 0, 1, 1, 1, 0, 0, 0},
                 {0, 1, 0, 1, 0, 0, 0, 0},
                 {0, 1, 1, 0, 1, 1, 0, 0},
                 {0, 1, 0, 1, 0, 1, 0, 0},
                 {0, 0, 0, 1, 1, 0, 1, 1},
                 {0, 0, 0, 0, 0, 1, 0, 0},
                 {0, 0, 0, 0, 0, 1, 0, 0}};
		 
		 op.DFS(A, 1, 8);
		
	}

}
