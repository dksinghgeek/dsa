package com.ggn.probs.algo.branchBound;

import java.util.ArrayList;
import java.util.List;

public class JobSequence {
	private static int UPPER_LIMIT = Integer.MAX_VALUE;
	private static int NODE_NO = 1;

	public static void jobSequenceSolution(int[][] cost) {
		List<Job> queue = new ArrayList<>();
		for (int i = 0; i < cost[0].length; i++) {

			Job job = new Job(NODE_NO++);
			job.jobId = i;
			int calculatedCost = calNSetCost(cost, job, i);
			if (calculatedCost > UPPER_LIMIT)
				continue;
			job.cost = calculatedCost;

			job.upper = calNSetUpper(cost, job);

			if (job.upper < UPPER_LIMIT) {
				UPPER_LIMIT = job.upper;
			}

			job.deadline = cost[2][i];
			job.time = cost[3][i];

			queue.add(job);
		}

		while (!queue.isEmpty()) {
			Job persistetedJob = queue.remove(0);

			if (persistetedJob.upper > UPPER_LIMIT)
				continue;

			for (int i = persistetedJob.jobId + 1; i < cost[0].length; i++) {
				int jobId = findNextJob(persistetedJob, cost, i);
				Job job = new Job(NODE_NO++);
				job.jobId = jobId;
				persistetedJob.child = job;
				job.parent = persistetedJob;
				int calculatedCost = calNSetCost(cost, job, jobId);
				if (calculatedCost > UPPER_LIMIT)
					continue;
				job.cost = calculatedCost;

				job.upper = calNSetUpper(cost, job);
				if (job.upper < UPPER_LIMIT) {
					UPPER_LIMIT = job.upper;
				}

				job.deadline = cost[2][i];
				job.time = cost[3][i];

				queue.add(job);
			}

			if (queue.isEmpty()) {
				Job temp = persistetedJob;
				Job head = null;

				int maxDeadline = Integer.MIN_VALUE;
				while (temp != null) {
					if (temp.deadline > maxDeadline)
						maxDeadline = temp.deadline;

					if (temp.parent == null)
						head = temp;

					temp = temp.parent;
				}

				List<Job> output = new ArrayList<>();
				while (maxDeadline > 0 && head != null) {
					output.add(head);
					maxDeadline = maxDeadline - head.time;
					head = head.child;
				}

				output.stream().forEach(t -> System.out.print(t.jobId + " "));
			}
		}
	}

	private static int findNextJob(Job job, int[][] cost, int id) {
		int jobId = -1;
		for (int i = id; i < cost[0].length; i++) {
			if (!isJobExits(job, i)) {
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
		while (temp != null) {
			if (temp.jobId == j)
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
		int cost[][] = { { 1, 2, 3, 4 }, { 5, 10, 6, 3 }, { 1, 3, 2, 1 }, { 1, 2, 1, 1 } };

		jobSequenceSolution(cost);

	}

}

class Job {
	int nodeNo;
	int upper;
	int cost;
	int jobId;
	int deadline;
	int time;
	Job parent;
	Job child;

	public Job(int nodeNo) {
		this.nodeNo = nodeNo;
	}
}
