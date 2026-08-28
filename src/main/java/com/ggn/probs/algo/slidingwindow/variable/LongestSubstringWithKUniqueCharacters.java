package com.ggn.probs.algo.slidingwindow.variable;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKUniqueCharacters {

	public int longestSubstringWithKUniqueCharacters(char[] A, int K) {
		int mx = Integer.MIN_VALUE;
		int i = 0;
		int j = 0;
		int n = A.length;
		Map<Character, Integer> m = new HashMap<Character, Integer>();

		while (j < n) {
			if (m.containsKey(A[j])) {
				int val = m.get(A[j]) + 1;
				m.put(A[j], val);
			} else {
				m.put(A[j], 1);
			}

			if (m.size() < K) {
				j++;
			} else if (m.size() == K) {
				mx = Math.max(j - i + 1, mx);
				j++;
			} else if (m.size() > K) {
				while (m.size() > K) {
					if (m.containsKey(A[j])) {
						int val = m.get(A[i]) - 1;
						if (val == 0) {
							m.remove(A[i]);
						} else {
							m.put(A[j], val);
						}
					}

					i++;
				}

				if (m.size() == K) {
					mx = Math.max(j - i + 1, mx);
				}

				j++;
			}
		}

		return mx;
	}

	public static void main(String[] args) {
		LongestSubstringWithKUniqueCharacters op = new LongestSubstringWithKUniqueCharacters();

		char[] A = { 'a', 'a', 'b', 'a', 'c', 'a', 'e' };
		int K = 3;

		System.out.println("Max substring : " + op.longestSubstringWithKUniqueCharacters(A, K));
	}

}
