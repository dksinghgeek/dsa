package com.ggn.probs.dsa.ds.dc;

public class BinarySearch {

	public int iBinarySearch(int[] items, int l, int h, int key) {
		if(l <= h) {
			int mid = (l+h)/2;
			
			if(items[mid] == key) {
				return mid;
			} else if(key < items[mid]) {
				h = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		
		return -1;
	}
	
	public int rBinarySearch(int[] items, int l, int h, int key) {
		if(l == h) {
			if(items[l] == key) {
				return l;
			} else {
				return -1;
			}
		} else {
			int mid = (l+h)/2;
			
			if(items[mid] == key) {
				return mid;
			} else if(key < items[mid]) {
				return rBinarySearch(items, l, mid - 1, key);
			} else {
				return rBinarySearch(items, mid + 1, h, key);
			}
		}
	}

	public static void main(String[] args) {
		int[] items = {1,2,3,4,5,6};
		BinarySearch op = new BinarySearch();
		System.out.println(op.rBinarySearch(items, 0, 5, 3));

	}

}
