package com.ggn.probs.algo.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestNoInArray {
    public int solve(int[] A, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < A.length; i++) {
            heap.offer(A[i]);

            if (heap.size() > k) {
                heap.poll();
            }
        }

        return heap.peek().intValue();
    }

    public static void main(String[] args) {
        KthSmallestNoInArray op = new KthSmallestNoInArray();

        int[] A = {7, 10, 4, 3, 20, 15};

        System.out.println(op.solve(A, 3));
    }
}
