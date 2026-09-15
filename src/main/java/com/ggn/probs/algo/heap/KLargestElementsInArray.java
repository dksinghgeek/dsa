package com.ggn.probs.algo.heap;

import java.util.PriorityQueue;

public class KLargestElementsInArray {
    public void solve(int[] A, int k){
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for(int i =0 ;i < A.length; i++){
            heap.offer(A[i]);

            if(heap.size() > k){
                heap.poll();
            }
        }

        while(heap.size() > 0){
            System.out.print(" " + heap.peek());
            heap.poll();
        }
    }

    public static void main(String[] args){
        KLargestElementsInArray op = new KLargestElementsInArray();

        int[] A = {7, 10, 4, 3, 20, 15};

        op.solve(A,3);
    }
}
