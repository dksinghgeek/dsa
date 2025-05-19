package com.ggn.probs.algo.variablesize.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithWithoutRepeatingCharacters {

	public int longestSubstringWithWithoutRepeatingCharacters(char[] A) {
		int mx = Integer.MIN_VALUE;
		int i = 0;
		int j = 0;
		int n = A.length;
		Map<Character, Integer> m = new HashMap<>();

		while (j < n) {
			if (m.containsKey(A[j])) {
				m.put(A[j], m.get(A[j]) + 1);
			} else {
				m.put(A[j], 1);
			}

			if (m.size() == j - i + 1) {
				mx = Math.max(mx, j - i + 1);
				j++;
			} else if (m.size() < j - i + 1) {
				while (m.size() < j - i + 1) {
					if (m.containsKey(A[i])) {
						int val = m.get(A[i]) - 1;
						if (val == 0) {
							m.remove(A[i]);
						} else {
							m.put(A[i], val);
						}
					}
					i++;
				}

				if (m.size() == j - i + 1) {
					mx = Math.max(mx, j - i + 1);
				}

				j++;
			}
		}

		return mx;
	}

	public static void main(String[] args) {
		LongestSubstringWithWithoutRepeatingCharacters op = new LongestSubstringWithWithoutRepeatingCharacters();
		char[] A = { 'p', 'w', 'w', 'k', 'e', 'w' };
		System.out.println(op.longestSubstringWithWithoutRepeatingCharacters(A));
	}

}
