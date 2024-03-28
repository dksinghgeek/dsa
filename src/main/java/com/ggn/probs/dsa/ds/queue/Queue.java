package com.ggn.probs.dsa.ds.queue;

public class Queue {
	private int front;
	private int rear;
	private int SIZE;
	private int[] queue;
	
	public Queue(int SIZE) {
		this.SIZE = SIZE;
		this.front = this.rear = -1;
		this.queue = new int[SIZE];
	}
	
	public void enqueue(int val) {
		if(this.rear == SIZE - 1) {
			System.out.println("Queue is full !!");
		} else {
			this.rear++;
			queue[rear] = val;
		}
	}
	
	public int dequeue() {
		int x = -1;
		if(front == rear) {
			System.out.println("Queue is empty !!");
		}else {
			front++;
			x = queue[front];
		}
		
		return x;
	}
	
	public boolean isEmpty() {
		return front == rear;
	}
	
	public void display() {
		for(int i = front + 1 ; i <= rear ; i++) {
			System.out.print(" " + queue[i]);
		}
	}

	public static void main(String[] args) {
		Queue queue = new Queue(5);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.enqueue(6);
		
		queue.display();
		
		System.out.println("\nDequeue : " + queue.dequeue());
		
		queue.display();
	}

}
