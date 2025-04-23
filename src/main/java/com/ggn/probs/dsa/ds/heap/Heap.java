package com.ggn.probs.dsa.ds.heap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class Heap {
	public void k_smallest(int[] keys, int K) {
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i = 0 ; i < keys.length; i++) {
			queue.offer(keys[i]);
			
			if(queue.size() > K) {
				queue.poll();
			}
		}
		
		while(!queue.isEmpty()) {
			System.out.print(queue.poll() + " ");
		}
	}
	
	public void k_largest(int[] keys, int K) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
		for(int i = 0; i < keys.length; i++) {
			queue.offer(keys[i]);
			
			if(queue.size() > K) {
				queue.poll();
			}
		}
		
		while(!queue.isEmpty()) {
			System.out.print(queue.poll() + " ");
		}
		
	}
	
	public void top_k_frequency(int[] keys, int K) {
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0 ; i < keys.length; i++) {
			map.put(keys[i], map.getOrDefault(keys[i], 0)+1);
		}
		
		PriorityQueue<Map.Entry<Integer, Integer> > queue
        = new PriorityQueue<>(
            (a, b)
                ->  Integer.compare(b.getValue(),
                                         a.getValue()));
		
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			queue.offer(entry);
		}
		
		for(int i = 0; i < K; i++) {
			System.out.print(queue.poll().getValue() + " ");
		}
 	}
	
	public void frequencySort(int[] keys) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i = 0 ; i < keys.length; i++) {
			map.put(keys[i], map.getOrDefault(keys[i], 0)+1);
		}
		
		PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(
				(a,b) -> Integer.compare(b.getValue(), a.getValue())
				);
		
		for(Entry<Integer, Integer> entry : map.entrySet()) {
			queue.offer(entry);
		}
		
		while(!queue.isEmpty()) {
			Entry<Integer,Integer> entry = queue.poll();
			for(int i = 0 ; i < entry.getValue(); i++) {
				System.out.print(entry.getKey() + " ");
			}
		}
	}

	public static void main(String[] args) {
		int[] keys = {1,3,2,4};
		
		Heap op = new Heap();
		
		//op.k_smallest(keys, 2);
		
		System.out.println();
		
		//op.k_largest(keys, 2);
		
		System.out.println();
		
		int[] freq = {1,1,1,3,2,2,4};
		
		//op.top_k_frequency(freq, 2);
		
		op.frequencySort(freq);
				
	}

}
