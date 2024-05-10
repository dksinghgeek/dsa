package com.ggn.probs.algo.greedy;

public class Kanpsack {
	public void kanpsackPro(int[] profits, int[] weight, int n, int M) {
		int[] profitsNWeight = new int[n];
		
		for(int i = 0; i < n; i++) {
			profitsNWeight[i] = profits[i]/weight[i];
		}
		
		for(int i = 0; i < n - 1; i++) {
			for(int j = 0; j < n - 1 - i ; j++) {
				if(profitsNWeight[j] < profitsNWeight[j+1]) {
					int t1 = profitsNWeight[j];
					profitsNWeight[j] = profitsNWeight[j+1];
					profitsNWeight[j+1] = t1;
					
					int t2 = profits[j];
					profits[j] = profits[j+1];
					profits[j+1] = t2;
					
					int t3 = weight[j];
					weight[j] = weight[j+1];
					weight[j+1] = t3;
				}
			}
		}
		
		
		double p = 0.0;
		for(int i = 0 ; i < n; i++) {
			if(M > 0 && weight[i] <= M) {
				M = M - weight[i];
				p +=profits[i];
			}else {
				if(M > 0) {
					p += ((double)profits[i]/(double)weight[i])*(double)M;
				}
				break;
			}
		}
		
		for(int i = 0; i < n; i++) {
			System.out.print(" " + profits[i]);
		}
		System.out.println();
		
		for(int i = 0; i < n; i++) {
			System.out.print(" " + weight[i]);
		}
		
		System.out.println();
		for(int i = 0; i < n; i++) {
			System.out.print(" " + profitsNWeight[i]);
		}
		
		System.out.println();
		
		System.out.println("Profit : " + p);
	}

	public static void main(String[] args) {
		Kanpsack op = new Kanpsack();
		int[] profits = {10,5,15,7,6,18,3};
		int[] weight = {2,3,5,7,1,4,1};
		op.kanpsackPro(profits, weight, 7, 15);
	}

}
