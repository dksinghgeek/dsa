package com.ggn.probs.dsa.ds.sort;

import java.util.LinkedList;

import com.ggn.probs.dsa.ds.linkedlist.Node;

public class SortingOperations {
	public void bubble(int[] A, int n) {
		for(int i = 0 ; i < n-1 ; i++) {
			boolean isAdaptive = false;
			for(int j = 0 ; j < n-1-i ; j++) {
				if(A[j+1] < A[j]) {
					int temp = A[j+1];
					A[j+1] = A[j];
					A[j] = temp;
					
					isAdaptive = true;
				}
			}
			if(!isAdaptive) break;
		}
	}
	
	public void insertion(int[] A, int n) {
		for(int i = 1 ; i < n ; i++) {
			int x = A[i];
			int j = i-1;
			
			while(j > -1 && A[j] > x) {
				A[j+1] = A[j];
				j = j-1;
			}
			A[j+1] = x;
		}
	}
	
	public void selection(int[] A, int n) {
		int k = 0; int j = 0;
		for(int i = 0 ; i < n - 1 ; i++) {
			for(j = k = i; j < n ; j++) {
				if(A[j] < A[k]) {
					k = j;
				}
			}
			
			int temp = A[i];
			A[i] = A[k];
			A[k] = temp;
		}
	}
	
	public int partition(int[] A, int l, int h) {
		int i = l; int j = h;
		int pivot = A[l];
		
		do {
			do {i++;} while(A[i] <= pivot);
			do {j--;} while(A[j] > pivot);
			
			if(i < j) {
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
			}
		} while (i < j);
		
		int temp = A[l];
		A[l] = A[j];
		A[j] = temp;
		
		return j;
	}
	
	public void quick(int[] A, int l , int h) {
		if(l < h) {
			int pivot  = partition(A, l, h);
			quick(A, l, pivot);
			quick(A, pivot + 1, h);
		}
	}
	
	public void merge(int[] A, int l , int mid , int h) {
		int i = l; int j = mid+1; int k = l;
		int[] B = new int[A.length];
		
		
		while(i <= mid && j <= h) {
			if(A[i] < A[j]) {
				B[k++] = A[i++];
			} else {
				B[k++] = A[j++];
			}
		}
		
		for(; i <= mid ; i++) {
			B[k++] = A[i];
		}
		
		for(; j <= h ; j++) {
			B[k++] = A[j];
		}
		
		for(int p = l ; p <= h; p++) {
			A[p] = B[p];
		}
	}
	
	public void rMerge(int[] A, int l, int h) {
		if(l < h) {
			int mid = (l+h)/2;
			rMerge(A, l, mid);
			rMerge(A, mid+1, h);
			merge(A, l, mid, h);
		}
	}
	
	public void iMerge(int[] A, int n) {
		int p; int i; int l ; int h;int mid;
		
		
		for(p = 2;  p < n ; p = p*2) {
			for(i = 0 ;  i+p-1 < n; i = i+p) {
				 l = i;
				 h = i+p-1;
				 mid = (l+h)/2;
				merge(A, l, mid, h);
			}
			if(n-i>p/2)
			 {
			 l = i;
			 h = i+p-1;
			 mid = (l+h)/2;
			 merge(A, l, mid, n-1);
			 } 
		}
		if(p/2 < n) {
			merge(A, 0, p/2-1, n-1);
		}
	}
	
	
	public int max(int[] A, int n) {
		int max = Integer.MIN_VALUE;
		
		for(int i = 0 ; i < A.length ; i++) {
			if(A[i] > max) {
				max = A[i];
			}
		}
		
		return max;
	}
	
	public void count(int[] A, int n) {
		int max = max(A, n);
		int[] C = new int[max+1];
		
		for(int i = 0 ; i < C.length ; i++) {
			C[i] = 0;
		}
		
		for(int j = 0 ; j < n ; j++) {
			C[A[j]]++;
		}
		
		int i = 0 ; int j = 0;
		while(j < C.length) {
			if(C[j] > 0) {
				A[i++] = j;
				C[j]--;
			}else {
				j++;
			}
		}
	}
	
	public void binSort(int[] A, int n) {
		int max = max(A, n);
		LinkedList<Integer>[] bins = new LinkedList[max+1];
		
		for(int i = 0 ; i < bins.length ; i++) {
			bins[i] = null;
		}
		
		for (int j = 0; j < n; j++) {
			if (bins[A[j]] == null) {
				bins[A[j]] = new LinkedList<>();
				bins[A[j]].addLast(A[j]);
			} else {
				bins[A[j]].addLast(A[j]);
			}
		}
		
		int i = 0 ; int j = 0;
		
		while(j < bins.length) {
			while(bins[j] != null) {
				A[i++] = bins[j].remove(0);
				if(bins[j].isEmpty()) {
					bins[j] = null;
				}
			}
			j++;
		}
	}
	
	public void shell(int[] A, int n) {
		int i; int j; int gap;
		
		for(gap = n/2 ; gap >= 1 ; gap = gap/2) {
			for(i = gap ; i < n ; i = i + 1) {
				int temp = A[i];
				j = i - gap;
				
				while(j >= 0 && A[j] > temp) {
					A[j+gap] = A[j];
					j = j - gap;
				}
				A[j+gap]= temp;
			}
		}
	}

	public static void main(String[] args) {
		SortingOperations op = new SortingOperations();
		int[] A = {7,6,5,4,3,2,1};
//		op.iMerge(A, A.length);
//		op.rMerge(A, 0, A.length - 1);
		
		op.shell(A, A.length);
		for(int i = 0 ; i < A.length ; i++) {
			System.out.print(" " + A[i]);
		}
	}

}
