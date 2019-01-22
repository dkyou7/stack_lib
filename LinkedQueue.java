package com.algo;

import java.util.Collection;
import java.util.Iterator;


public class LinkedQueue {
	public static void main(String[] args) {
		
	}
}

//연결 큐 구현
class MyLinkedQueue{
	private QueueNode front,rear;
	
	public boolean isEmpty() {
		return front == rear;
	}
	
	public void enQueue(Object data) {
		if(front == null) {
			rear = new QueueNode(data,null);
			front = new QueueNode(rear);
		}
		else {
			rear = rear.next = new QueueNode(data,null);
		}
	}
	
	public Object deQueue() {
		QueueNode p = front.next;
		front.next = p.next;
		return p.data;
	}
	
	public Object Qpeek() {
		return front.next.data;
	}
	
	class QueueNode{
		Object data;
		QueueNode next;
		QueueNode(Object data, QueueNode next){
			this.data = data;
			this.next =next;
		}
		QueueNode(QueueNode next){
			this.next = next;
		}
	}
}
