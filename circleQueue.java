package com.algo;

public class circleQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyQueue2<String> queue = new MyQueue2<>();
		queue.enQueue("C");
		queue.enQueue("i");
		queue.enQueue("r");
		queue.enQueue("c");
		queue.enQueue("l");
		queue.enQueue("e");
		queue.enQueue("Q");
		queue.enQueue("u");
		queue.enQueue("e");
		queue.enQueue("u");
		queue.enQueue("e");
		
		System.out.println(queue);
	}

}

@SuppressWarnings("unchecked")
class MyQueue2<T>{
	T[] data = (T[]) new Object[11];
	int front = -1, rear = -1;

	public boolean enQueue(T v) {
		if(isFull()) return false;
		rear = (rear+1)%11;
		data[rear] = v;
		return true;
	}
	
	public T DeQueue() {
		if(isEmpty()) return null;
		front = (front+1)%11;
		return data[front];
		
	}
	
	public boolean isEmpty() {
		return front == rear;
	}
	
	public boolean isFull() {
		return (rear+1)%data.length == front;
	}
	
	public T Qpeek() {
		if(isEmpty()) return null;
		return data[front+1];
	}
	
	public String toString() {
		StringBuffer buf = new StringBuffer("[");
		if(!isEmpty()) buf.append(data[0]);
		for(int i = 1; i < data.length; i++) {
			buf.append(", "+data[i]);
		}
		buf.append("]");
		return buf + "";
	}
}