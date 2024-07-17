package com.ggn.probs.algo.stringsearch;import java.util.regex.Pattern;

public class RobinKarp {

	private static int hash(char[] pattern, int start, int noOfChars) {
		int hash = 0;
		while (noOfChars >= 0) {
			hash += pattern[start] * Math.pow(10, noOfChars);
			start++;
			noOfChars--;
		}

		return hash;
	}
	
	private static boolean compare(char[] text, char[] pattern) {
		for(int i = 0; i <= text.length-pattern.length; i++) {
			int j;
			for(j = 0 ; j < pattern.length; j++) {
				if(text[i+j] != pattern[j])
					break;
			}
			
			if(j == pattern.length)
				return true;
		}
		return false;
	}

	public static boolean robinKarpSolution(char[] text, char[] patten) {
		int patternHash  = hash(patten, 0, patten.length-1);
		
		for(int i = 0 ; i <= text.length - patten.length ; i++) {
			int hash = hash(text, i, patten.length-1);
			if(hash == patternHash) {
				char[] substringChars = String.valueOf(text).substring(i, i+patten.length).toCharArray();
				if(compare(substringChars, patten)) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		String txt1 = "AABAACAADAABAABA";
        String pat1 = "BAABA";

        System.out.println(robinKarpSolution(txt1.toCharArray(), pat1.toCharArray()));
	}

}
