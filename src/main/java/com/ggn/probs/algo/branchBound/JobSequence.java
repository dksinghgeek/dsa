package com.ggn.probs.algo.branchBound;

import java.util.ArrayList;
import java.util.List;

public class JobSequence {
	private static int UPPER_LIMIT = Integer.MAX_VALUE;
	private static int NODE_NO = 1;
	
	public static int jobSequenceSolution(int[][] cost) {	
		List<List<Job>> solution = new ArrayList<>();
		List<Job> queue = new ArrayList<>();
		for(int i = 0 ; i < cost[0].length; i++) {
			
			Job job = new Job(NODE_NO++);
			job.jobId = i;
			int calculatedCost = calNSetCost(cost, job, i);
			System.out.println(calculatedCost);
			if(calculatedCost > UPPER_LIMIT)
				continue;
			job.cost = calculatedCost;
			
			job.upper = calNSetUpper(cost, job);
			System.out.println(job.upper);
			
			if(job.upper < UPPER_LIMIT) {
				UPPER_LIMIT = job.upper;
			}
			
			queue.add(job);
		}
		
		while (!queue.isEmpty()) {
			Job persistetedJob = queue.remove(0);
			
			for (int i = persistetedJob.jobId+1; i < cost[0].length; i++) {
				int jobId = findNextJob(persistetedJob, cost, i);
				Job job = new Job(NODE_NO++);
				job.jobId = jobId;
				job.parent = persistetedJob;
				int calculatedCost = calNSetCost(cost, job, jobId);
				if (calculatedCost > UPPER_LIMIT)
					continue;
				job.cost = calculatedCost;

				job.upper = calNSetUpper(cost, job);
				if (job.upper < UPPER_LIMIT) {
					UPPER_LIMIT = job.upper;
				}

				queue.add(job);
			}
		}
		

		return UPPER_LIMIT;
	}

	private static int findNextJob(Job job, int[][] cost, int id) {
		int jobId = -1;
		for(int i = id ; i < cost[0].length; i++) {
			if(!isJobExits(job, i)) {
				jobId = i;
				break;
			}
		}
		return jobId;
	}

	private static int calNSetUpper(int[][] cost, Job job) {
		int u = 0;

		for (int j = 0; j < cost[0].length; j++) {
			if (!isJobExits(job, j)) {
				u += cost[1][j];
			}
		}

		return u;
	}

	private static boolean isJobExits(Job job, int j) {
		Job temp = job;
		while(temp != null) {
			if(temp.jobId == j)
				return true;
			temp = temp.parent;
		}
		return false;
	}

	private static int calNSetCost(int[][] cost, Job job, int i) {
		int c = 0;

		for (int j = 0; j < i; j++) {
			if (!isJobExits(job, j)) {
				c += cost[1][j];
			}
		}

		return c;
	}

	public static void main(String[] args) {
		int cost[][] = { 
				{ 1, 2,  3, 4},
				{ 5, 10, 6, 3 }, 
				{ 1, 3,  2, 1 }, 
				{ 1, 2,  1, 1 } };
				
		jobSequenceSolution(cost);
		
	}

}

class Job {
	int nodeNo;
	int upper;
	int cost;
	int jobId;
	Job parent;
	
	public Job(int nodeNo) {
		this.nodeNo = nodeNo;
	}
}
