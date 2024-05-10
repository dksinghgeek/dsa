package com.ggn.probs.algo.dp;

import java.util.Arrays;

public class BellManFord {
	
	public void bellmanFordAlgo(Graph graph, int src) {
		int V = graph.V;
		int E = graph.E;
		int[] dest = new int[V];
		
		Arrays.fill(dest, Integer.MAX_VALUE);
		dest[src] = 0;
		
		for(int i = 0 ; i < V - 1; i++) {
			for(int j = 0 ; j < E ; j++) {
				int u = graph.edge[j].src;
				int v = graph.edge[j].dest;
				int W = graph.edge[j].weight;
				if(dest[i] != Integer.MAX_VALUE && dest[u] + W < dest[v]) {
					dest[v] = dest[u] + W;
				}
			}
		}
		
		for(int j = 0 ; j < E; j++) {
			int u = graph.edge[j].src;
			int v = graph.edge[j].dest;
			int W = graph.edge[j].weight;
			
			if(dest[u] != Integer.MAX_VALUE && dest[u]+W < dest[v]) {
				System.out.println("Negative weight cycle");
				return;
			}
		}
		
		print(dest, V);
		
	}

	private void print(int[] dest, int v) {
		for(int i = 0; i < v ; i++) {
			System.out.print(" " + dest[i]);
		}
		
	}

	public static void main(String[] args) {
		int V = 5; // Number of vertices in graph
        int E = 8; // Number of edges in graph

        Graph graph = new Graph(V, E);

        // add edge 0-1 (or A-B in above figure)
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = -1;

        // add edge 0-2 (or A-C in above figure)
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 4;

        // add edge 1-2 (or B-C in above figure)
        graph.edge[2].src = 1;
        graph.edge[2].dest = 2;
        graph.edge[2].weight = 3;

        // add edge 1-3 (or B-D in above figure)
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 2;

        // add edge 1-4 (or B-E in above figure)
        graph.edge[4].src = 1;
        graph.edge[4].dest = 4;
        graph.edge[4].weight = 2;

        // add edge 3-2 (or D-C in above figure)
        graph.edge[5].src = 3;
        graph.edge[5].dest = 2;
        graph.edge[5].weight = 5;

        // add edge 3-1 (or D-B in above figure)
        graph.edge[6].src = 3;
        graph.edge[6].dest = 1;
        graph.edge[6].weight = 1;

        // add edge 4-3 (or E-D in above figure)
        graph.edge[7].src = 4;
        graph.edge[7].dest = 3;
        graph.edge[7].weight = -3;
        
        BellManFord op = new BellManFord();
        
          // Function call
        op.bellmanFordAlgo(graph, 0);
	}

}

class Edge {
	int src;
	int dest;
	int weight;
	
	public Edge () {
		src = dest = weight = 0;
	}
}

class Graph {
	int V;
	int E;
	Edge[] edge;
	
	public Graph(int v, int e) {
		this.V = v;
		this.E = e;
		this.edge = new Edge[E];
		
		for(int i = 0 ; i < e ; i++) {
			edge[i] = new Edge();
		}
	}
}
