package com.ggn.probs.algo.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JobScheduling {
	public void jobSchedulingAlgo(List<Job> jobs, int n) {
		Collections.sort(jobs, (j1, j2) -> j2.profit - j1.profit);
		
		boolean[] included = new boolean[n];
		
		char[] result = new char[n];
		
		for(int i = 0 ; i < n ; i++) {
			for(int j = Math.min(n-1, jobs.get(i).deadline-1) ; j >=0 ; j--) {
				if(included[j] == false) {
					included[j] = true;
					result[j] = jobs.get(i).id;
					break;
				}
			}
		}
		
		for(int i = 0 ; i < n ; i++) {
			System.out.print(" " + result[i]);
		}
	}

	public static void main(String[] args) {
		List<Job> arr = new ArrayList<Job>();
        arr.add( new Job('a', 6, 100));
        arr.add(new Job('b', 1, 19));
        arr.add(new Job('c', 2, 27));
        arr.add(new Job('d', 1, 25));
        arr.add(new Job('e', 3, 15));
        
        JobScheduling op = new JobScheduling();
        op.jobSchedulingAlgo(arr, 5);
	}
}

class Job {
	char id;
	int profit;
	int deadline;
	
	public Job(char id, int deadline, int profit) {
		this.id = id;
		this.profit = profit;
		this.deadline = deadline;
	}
}
