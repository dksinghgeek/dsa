package com.ggn.probs.algo.fixedsize.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class CountOccurrencesOfAnagrams {

	public int countOccurrencesOfAnagrams(char[] A, char[] B) {
		int output = 0;
		int i = 0;
		int j = 0;
		int n = A.length;
		int K = B.length;
		Map<Character, Integer> m = processPattern(B);
		int count = m.size();

		while (j < n) {
			if (m.containsKey(A[j])) {
				int val = m.get(A[j]) - 1;
				m.put(A[j], val);

				if (val == 0) {
					count--;
				}
			}

			if (j - i + 1 < K) {
				j++;
			} else if (j - i + 1 == K) {
				if (count == 0) {
					output++;
				}

				int val = m.get(A[i]) + 1;
				if (val == 1) {
					count++;
				}
				m.put(A[i], val);
				i++;
				j++;
			}

		}

		return output;
	}

	private Map<Character, Integer> processPattern(char[] B) {
		Map<Character, Integer> m = new HashMap<>();
		for (int i = 0; i < B.length; i++) {
			if (m.containsKey(B[i])) {
				m.put(B[i], m.get(B[i]) + 1);
			} else {
				m.put(B[i], 1);
			}
		}

		return m;
	}

	public static void main(String[] args) {
		CountOccurrencesOfAnagrams op = new CountOccurrencesOfAnagrams();
		char[] A = { 'a', 'a', 'b', 'a', 'a', 'b', 'a', 'a' };
		char[] B = { 'a', 'a', 'b', 'a' };
		
		System.out.println(op.countOccurrencesOfAnagrams(A, B));
	}

}
