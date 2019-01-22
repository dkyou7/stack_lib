package com.algo;

public class myStack {
	public static void main(String[] args) {
		MyStack1<Integer> stack = new MyStack1<>();
		stack.push(1);
		stack.push(3);
		stack.push(2);
		System.out.println(stack.pop());
		stack.push(4);
		System.out.println(stack);
	}
}

@SuppressWarnings("unchecked")
class MyStack1<T>{
	private T[] data = (T[]) new Object[100];
	private int top = 0;

	public T push(T v) {
		if(top == data.length) {
			T[] tdata = (T[]) new Object[top*2];
			System.arraycopy(data, 0, tdata, 0, top);
			data = tdata;
		}
		data[top++] = v;
		return v;
	}

	public T pop() {
		if(isEmpty()) return null;
		return data[--top];
	}

	public T peek() {
		if(isEmpty()) return null;
		return data[top-1];
	}

	public boolean isEmpty() {
		return top == 0;
	}

	public int size() {
		return top;
	}

	public String toString() {
		StringBuffer buf = new StringBuffer("[");
		if(!isEmpty()) buf.append(data[0]);
		for(int i = 1; i < top; i++) {
			buf.append(", "+data[i]);
		}
		buf.append("]");
		return buf+"";
	}
}
