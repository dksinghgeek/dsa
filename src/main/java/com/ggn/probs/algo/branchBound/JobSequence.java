package com.ggn.probs.algo.branchBound;

import java.util.Stack;

public class JobSequence {
	private static int upperLimit = Integer.MAX_VALUE;
	
	public static int jobSequenceSolution(int[][] cost) {
		Stack<Job> stack = new Stack<>();
		

		return upperLimit;
	}

	public static void main(String[] args) {
		int cost[][] = { 
				{ 1, 2,  3, 4},
				{ 5, 10, 6, 3 }, 
				{ 1, 3,  2, 1 }, 
				{ 1, 2,  1, 1 } };
		
//		Job j1 = new Job("j1", 5, 1, 1);
//		Job j2 = new Job("j2", 10, 3, 2);
//		Job j3 = new Job("j3", 6, 2, 1);
//		Job j4 = new Job("j4", 3, 1, 1);
//		
//		List<Job> jobs = new ArrayList<>();
//		jobs.add(j1);
//		jobs.add(j2);
//		jobs.add(j3);
//		jobs.add(j4);
//		
		jobSequenceSolution(cost);
		
	}

}

class Job {
	String name;
	int panelty;
	int deadline;
	int time;
	int upper;
	int cost;
	Job parent;
	
	public Job(String name, int panelty, int deadline, int time) {
		this.name = name;
		this.panelty = panelty;
		this.deadline = deadline;
		this.time = time;
	}
}
