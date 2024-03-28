package com.ggn.probs.dsa.ds.randomQ;

public class PrimeOperations {
	private int i = 2;
	
	public boolean isPrimeR(int n) {
		if(n == 0 || n == 1)
			return false;
		
		if(n == i)
			return true;
		
		if(n % i == 0)
			return false;
		
		i++;
		return isPrimeR(n);
	} 
	
	public void prime(int n) {
		if(n == 0 || n == 1)
			System.out.println("Non prime");
		
		boolean isPrime = true;
		for(int i = 2; i <= Math.sqrt(n) ; i++) {
			if(n % i == 0) {
				isPrime = false;
				break;
			}
		}
		
		if(isPrime)
			System.out.println("Prime");
		else {
			System.out.println("Non Prime");
		}
	}
	

	public static void main(String[] args) {
		PrimeOperations op = new PrimeOperations();
//		if(op.isPrimeR(35)) {
//			System.out.println("Prime");
//		}else {
//			System.out.println("Non Prime");
//		}
		
		op.prime(7);
	}

}
