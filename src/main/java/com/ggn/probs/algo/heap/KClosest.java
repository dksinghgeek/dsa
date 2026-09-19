package com.ggn.probs.algo.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosest {
    public void solve(int[] A, int k, int x) {
        PriorityQueue<Pair<Integer, Integer>> heap = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return Integer.compare(o2.getKey(), o1.getKey());
            }
        });

        for (int i = 0; i < A.length; i++) {
            int distance = Math.abs(A[i] - x);

            heap.offer(new Pair<Integer, Integer>(distance, A[i]));

            if (heap.size() > k) {
                heap.poll();
            }
        }

        while (heap.size() > 0) {
            System.out.print(" " + heap.peek().getValue());
            heap.poll();
        }
    }

    public static void main(String[] args) {
        KClosest op = new KClosest();

        int[] A = {1, 3, 5, 8, 10};
        op.solve(A, 2, 7);
    }
}
