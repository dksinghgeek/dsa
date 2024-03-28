package com.ggn.probs.dsa.ds.hashing;

import java.util.Collections;
import java.util.LinkedList;

public class Chaining {
	private LinkedList<Integer>[] H = new LinkedList[10];
	
	private int hash(int key) {
		return key%10;
	}
	
	public void insert(int key) {
		int index = hash(key);
		
		if(H[index] != null)
			H[index].add(key);
		else {
			H[index] = new LinkedList<Integer>();
			Collections.sort(H[index]);
			H[index].add(key);
		}
	}
	
	public int search(int key) {
		int index = hash(key);
		
		if(H[index] != null) {
			LinkedList<Integer> chain = H[index];
			
			int i = 0;
			while(chain != null) {
				int found = chain.get(i);
				if(found == key) {
					return i;
				}
				i++;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		Chaining op = new Chaining();
		op.insert(1);
		op.insert(5);
		op.insert(55);
		op.insert(25);
		op.insert(11);
		
		System.out.println("search : " + op.search(55));
	}
}
