package com.ggn.probs.algo.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {
    public void solve(int[] A) {
        Map<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            mp.put(A[i], mp.getOrDefault(A[i], 0) + 1);
        }

        PriorityQueue<Pair<Integer, Integer>> heap = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return Integer.compare(o1.getValue(), o2.getValue());
            }
        });

        for (Map.Entry<Integer, Integer> entry : mp.entrySet()){
            heap.offer(new Pair<>(entry.getKey(), entry.getValue()));
        }

        while(!heap.isEmpty()){
            Pair pair = heap.peek();
            System.out.println("Data : " + pair.getKey() + " Frequency : " + pair.getValue());
            heap.poll();
        }

    }

    public static void main(String[] args) {
        FrequencySort op = new FrequencySort();

        int[] A = {5, 9, 1, 1, 3, 3, 5, 9, 5};

        op.solve(A);
    }
}
