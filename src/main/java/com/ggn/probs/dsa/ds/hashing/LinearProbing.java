package com.ggn.probs.dsa.ds.hashing;

public class LinearProbing {
	private int[] H = {0,0,0,0,0,0,0,0,0,0};
	
	private int hash(int key) {
		return key%10;
	}
	
	public void insert(int key) {
		int index = hash(key);
		
		int i = 0;
		
		while(H[index+i] != 0) {
			i++;
		}
		
		H[index+i] = key;
	}
	
	public int search(int key) {
		int index = hash(key);
		
		int i = 0;
		while(H[index + i] != 0) {
			if(H[index + i] == key)
				return index+i;
			i++;
		}
		return -1;
	}

	public static void main(String[] args) {
		LinearProbing op = new LinearProbing();
		op.insert(1);
		op.insert(5);
		op.insert(55);
		op.insert(25);
		op.insert(11);
		
		System.out.println("Search : " + op.search(25));
		
	}

}
