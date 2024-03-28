package com.ggn.probs.dsa.ds.array;

public class BinarySearch {
	
	public int rotatedArray(int[] A, int key) {
		int l = 0 ; int h = A.length - 1;
		
		while(l <= h) {
			int mid = (l+h)/2;
			
			if(A[mid] == key) {
				return mid;
			}
			
			if(A[l] < A[mid]){
				if(A[l] >= key && A[mid] < key) {
					h = mid - 1;
				}else {
					l = mid + 1;
				}
			} else {
				if(A[mid] < key && key <= A[h]) {
					l = mid + 1;
				} else {
					h = mid - 1;
				}
			}
			
			
		}
		
		return -1;
	}

	public static void main(String[] args) {
		BinarySearch op = new BinarySearch();
		int[] A = {9,10,11,1,3,5,6,7};
		System.out.println(op.rotatedArray(A, -1));

	}

}
