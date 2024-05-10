package com.ggn.probs.algo.greedy;

import java.util.PriorityQueue;

public class OptimalMerge {
	public void OptimalMergeAlgo(int[] files, int n) {
		PriorityQueue<Integer> q = new PriorityQueue<>();
		
		for(int i = 0 ; i < n ; i++) {
			q.add(files[i]);
		}
		
		int count = 0;
		while(q.size() > 1) {
			int temp = q.poll() + q.poll();
			count += temp;
			q.add(temp);
		}
		
		System.out.println("Count : " + count);
	}

	public static void main(String[] args) {
		int files[] = new int[] { 2, 3, 4, 5, 6, 7 };
		OptimalMerge op = new OptimalMerge();
		op.OptimalMergeAlgo(files, 6);
	}

}
