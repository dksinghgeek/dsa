package com.ggn.probs.dsa.ds.recursion;

import java.util.Set;
import java.util.TreeSet;

public class Subsets {
	Set<String> set = new TreeSet<>();

	public void allSolve(String ip, String op) { //powerSet, All subsequence
		if (ip.length() == 0) {
			System.out.print(" " + op);
			return;
		} else {
			String op1 = op + "";
			String op2 = op + ip.charAt(0);
			ip = ip.substring(1);
			allSolve(ip, op1);
			allSolve(ip, op2);
		}
	}
	
	public void uniqueSubset(String ip, String op){
		if(ip.length() == 0 && !set.contains(op)) {
			set.add(op);
			return;
		} else {
			String op1 = op + "";
			String op2 = op + ip.charAt(0);
			ip = ip.substring(1);
			uniqueSubset(ip, op1);
			uniqueSubset(ip, op2);
		}
	}

	public static void main(String[] args) {
		Subsets ob = new Subsets();
		String ip = "abcd";
		String op = "";
		
		
		ob.uniqueSubset(ip, op);
		ob.set.forEach(s -> System.out.print(" " + s));
	}

}
