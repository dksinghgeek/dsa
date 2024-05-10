package com.ggn.probs.algo.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HuffmanCode {
	
	
	public HuffmanNode huffmanCodeAlgo(char[] c, int[] f , int n) {
		PriorityQueue<HuffmanNode> q = new PriorityQueue<>(n, new customComparator());
		
		for(int i = 0 ; i < n ; i++) {
			HuffmanNode node = new HuffmanNode();
			node.c = c[i];
			node.f = f[i];
			
			node.left = null;
			node.right = null;
			
			q.add(node);
		}
		
		HuffmanNode root = null;
		while(q.size() > 1) {
			HuffmanNode f1 = q.peek();
			q.poll();
			
			HuffmanNode f2 = q.peek();
			q.poll();
			
			HuffmanNode temp = new HuffmanNode();
			temp.f = f1.f + f2.f;
			temp.c = '-';
			
			temp.left = f1;
			temp.right = f2;
			root = temp;
			q.add(temp);
			
		}
		
		return root;
	}
	
	public void print(HuffmanNode node, String s) {
		if(node.left == null && node.right == null && Character.isLetter(node.c)) {
			System.out.println(node.c +  ":" + s);
			return;
		}
		
		print(node.left, s+"0");
		print(node.right, s+"1");
	}
	
	public static void main(String[] args) {
		int n = 6; 
        char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' }; 
        int[] charfreq = { 5, 9, 12, 13, 16, 45 }; 
        
        HuffmanCode op = new HuffmanCode();
        HuffmanNode root =  op.huffmanCodeAlgo(charArray, charfreq, n);
        op.print(root, "");
        
	}

}

class HuffmanNode {
	char c;
	int f;
	HuffmanNode left;
	HuffmanNode right;
}

class customComparator implements Comparator<HuffmanNode> {

	@Override
	public int compare(HuffmanNode o1, HuffmanNode o2) {
		return o1.f - o2.f;
	}
	
}
