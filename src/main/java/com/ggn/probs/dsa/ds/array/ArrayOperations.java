package com.ggn.probs.dsa.ds.array;

public class ArrayOperations {
	public int removeElement(int[] nums, int val) {
        int size = nums.length;
        int i = nums.length - 1;

        while(i >= 0){
            if(nums[i] == val){
            	int j;
                for(j = i+1; j < size ; j++){
                    nums[j-1] = nums[j];
                }
                nums[j-1] = 0;
                size--;
            }
            i--;
        }

        System.out.println(nums);
        return size;
    }
	
	public void rotation(int[] keys, int n) {
		int temp = keys[0]; 
		
		for(int i = 0 ; i < n - 1 ; i++) {
			keys[i] = keys[i+1];
		}
		
		keys[n-1] = temp;
	}
	
	public static void main(String[] args) {
		ArrayOperations op = new ArrayOperations();
		int[] nums = {0,1,2,2,3,0,4,2};
//		System.out.println(op.removeElement(nums, 2));
		
		int i = 0;
		while(i < 20) {
			op.rotation(nums, 8);
			
			for(int j = 0 ; j < nums.length ; j++) {
				System.out.print(" " + nums[j]);
			}
			
			System.out.println();
			i++;
		}
	}
}
