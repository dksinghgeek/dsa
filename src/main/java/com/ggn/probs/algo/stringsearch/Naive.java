package com.ggn.probs.algo.stringsearch;

public class Naive {
	public static boolean naiveSolution(char[] text, char[] pattern) {
		for(int i = 0; i <= text.length - pattern.length; i++) {
			int j;
			for(j=0 ; j < pattern.length; j++) {
				if(text[i+j] != pattern[j])
					break;
			}
			
			if(j == pattern.length)
				return true;
		}
		
		return false;
	}

	public static void main(String[] args) {
		String str = "abcxabcdabcdabcy";
        String subString = "abcdabcy";
        System.out.println(naiveSolution(str.toCharArray(), subString.toCharArray()));
        ;
	}

}
