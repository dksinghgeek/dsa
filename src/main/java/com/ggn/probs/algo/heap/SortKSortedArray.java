package com.ggn.probs.algo.heap;

import java.util.PriorityQueue;

public class SortKSortedArray {
    public void solve(int[] A, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for(int i = 0; i < A.length; i++){
            heap.offer(A[i]);

            if(heap.size() > k){
                System.out.print(" " + heap.peek());
                heap.poll();
            }
        }

        while(heap.size() > 0){
            System.out.print(" " + heap.peek());
            heap.poll();
        }
    }

    public static void main(String[] args) {
        SortKSortedArray op = new SortKSortedArray();
        int[] A = {6, 5, 3, 2, 8, 10, 9};

        op.solve(A, 3);
    }
}
