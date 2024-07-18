package com.ggn.probs.algo.stringsearch;

public class KMP {
	

	public static int[] computeTemporarayArray(char[] P) {
		int[] lps = new int[P.length];
		
		int index = 0;
		lps[0] = 0;
		for(int i = 1; i < P.length;) {
			if(P[index] == P[i]) {
				lps[i] = index + 1;
				index++;
				i++;
			} else {
				if(index != 0) {
					index = lps[index-1];
				} else {
					lps[i] = 0;
					i++;
				}
			}
		}
		
		return lps;
	}
	
	public static boolean KMPSolution(char[] text, char[] pattern) {
		int[] lps = computeTemporarayArray(pattern);
		
		int i = 0;
		int j = 0;
		
		while(i < text.length && j < pattern.length) {
			if(text[i] == pattern[j]) {
				j++;
				i++;
			} else {
				if(j != 0) {
					j = lps[j-1];
				} else {
					i++;
				}
			}
		}
		
		if(j == pattern.length) {
			return true;
		}
		
		return false;
	}

	public static void main(String[] args) {
		String str = "abcxabcdabcdabcy";
        String subString = "abcdabcy";

        boolean result = KMPSolution(str.toCharArray(), subString.toCharArray());
        System.out.print(result);
	}

}
