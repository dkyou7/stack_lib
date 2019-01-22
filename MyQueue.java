package com.algo;

public class MyQueue {

	public static void main(String[] args) {
		MyQ<Integer> q = new MyQ<>();
		q.enQueue(1);
		q.enQueue(3);
		q.enQueue(2);
//		System.out.println(q);
		System.out.println("size : " + q.size());
		System.out.println(q.deQueue());
		System.out.println("q peek : " + q.peek());
		System.out.println("size : " + q.size());
		System.out.println(q.deQueue());
		System.out.println("q peek : " + q.peek());
		System.out.println("size : " + q.size());
		System.out.println(q.deQueue());
		System.out.println("size : " + q.size());
	}

}
@SuppressWarnings("unchecked")
class MyQ<T>{
	private T[] data = (T[]) new Object[100];
	private int front = -1;
	private int rear = -1;

	public void enQueue(T d) {
		if(isFull()) {
			T[] tdata = (T[]) new Object[rear*2];
			System.arraycopy(data, 0, tdata, 0, rear);
			data = tdata;
		}
		data[++rear]=d;
	}

	public T deQueue() {
		return data[++front];
	}

	public T peek() {
		if(isEmpty()) return null;
		return data[front+1];
	}

	public boolean isEmpty() {
		return front == rear;
	}
	public boolean isFull() {
		return rear == data.length-1;
	}
	public int size() {
		return rear-front;
	}

	public String toString() {
		StringBuffer buf = new StringBuffer("[");
		if(!isEmpty()) buf.append(data[0]);
		for(int i = 1; i <= rear; i++) {
			buf.append(", "+data[i]);
		}
		buf.append("]");
		return buf+"";
	}
}