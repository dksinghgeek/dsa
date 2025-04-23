package com.ggn.probs.dsa.ds.dc;

public class MaxHeap {

	public void createHeap(int[] keys, int index) {
		while (index / 2 > 0) {
			if (keys[index / 2] < keys[index]) {
				int temp = keys[index];
				keys[index] = keys[index / 2];
				keys[index / 2] = temp;
				index = index / 2;
			} else {
				return;
			}
		}
	}

	public int delete(int[] keys, int index) {
		int value = keys[1];
		keys[1] = keys[index];
		int i = 1;
		int j = 2 * i;

		while (j < index) {
			if (keys[j + 1] > keys[j]) {
				j = j + 1;
			}

			if (keys[j] > keys[i]) {
				int temp = keys[i];
				keys[i] = keys[j];
				keys[j] = temp;
			}

			i = j;
			j = 2 * i;
		}
		
		keys[index] = value;
		return value;
	}
	
	public void heapify(int[] keys, int index) {
		int i = index;
		int j = 2*i;
		
		while(j < keys.length) {
			if((j + 1) < keys.length) {
				if(keys[j+1] > keys[j]) {
					j = j + 1;
				}
			}
			
			if(keys[j] > keys[i]) {
				int temp = keys[i];
				keys[i] = keys[j];
				keys[j] = temp;
			}
			
			i = j;
			j = 2*j;
		}
	}

	public static void main(String[] args) {
		int[] keys = { 0, 10, 20, 12, 30, 40 };
		MaxHeap op = new MaxHeap();

//		for (int i = 1; i < keys.length; i++) {
//			op.createHeap(keys, i);
//		}
//
//		for (int i = 1; i < keys.length; i++) {
//			System.out.print(keys[i] + " ");
//		}
//		
//		System.out.println();
//		for (int i = keys.length - 1; i > 0; i--) {
//			System.out.print(op.delete(keys, i) + " ");
//		}
//
//		System.out.println();
//		for (int i = 1; i < keys.length; i++) {
//			System.out.print(keys[i] + " ");
//		}
		
		System.out.println();
		for (int i = keys.length - 1; i > 0; i--) {
			op.heapify(keys, i);
		}
		
		System.out.println();
		for (int i = 1; i < keys.length; i++) {
			System.out.print(keys[i] + " ");
		}
		
	}

}
