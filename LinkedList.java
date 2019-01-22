package com.algo;

public class LinkedList {

	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		//400 300 200 100 순서로 쌓인다.
		list.addToFirst(100);
		list.addToFirst(200);
		list.addToFirst(300);
		list.addToFirst(400);
	
		System.out.println(list.get(2));
	}
}


class MyLinkedList{
	private Node header; //리스트의 가장 첫 노드를 기억할 변수
	private int size;

	public MyLinkedList() {
		header  = new Node(null);
		size=0;
	}


	public void addToFirst(Object data) {
		Node newNode = new Node(data);		//기존의 0번보다 앞에 추가되랴 하는 노드객체
		newNode.nextNode = header.nextNode;	//기존 0번 노드객체의 주소를 새로운 애한테 주고
		header.nextNode = newNode;	//헤더는 추가된 새 노득체의 주소로 갱신함.
		size++;
	}


	public void addToLast(Object data) {
		Node newNode = new Node(data);
		Node currLastNode = getNode(size-1);		//현재의 리스트에 달여있는 애중 가장 마지막 노트 찾아오라하기
		currLastNode.nextNode =  newNode;
		size++;
	}

	public void delete(int index) {
		if(index==0) {
			header.nextNode = getNode(1);
			size--;
		}else {
			Node deleteNode = getNode(index);
			Node prevNode = getNode(index-1);
			size--;
			prevNode.nextNode = deleteNode.nextNode;
		}
	}
	public int size() {
		return size;
	}
	public Object get(int index) {
		return getNode(index).data;
	}
	
	private void add(int index,Object data) {
		if (index==0) {
			addToFirst(data);
			return;
		}
		Node find = getNode(index-1);
		Node newNode = new Node(data);

		//예를 들어 2번위치에 삽입하려는 경우 2번노드의 주소는 1번노트.nextNode 변수에 들어있음.
		//삽입하고자 하는 새 노드가 2번이던 노드의 주소를 받고 1번노드는 새 노드를 가리키게 만들면 됨.
		newNode.nextNode = find.nextNode;
		find.nextNode = newNode;
	}


	//연결 리스트를 사용하는 사용자는 아래의 Node관련 과정은 알 필요가 없음 그냥 data 추가 ,조회,삭제만 하면된다.
	private Node getNode(int index) {

		if(index<0 || index>=size) {
			System.err.println("리스트 범위 벗어나는 일을 했습니다.");
			System.out.println("index : "+index+",size :"+size);
			return null;
		}

		Node node = header.nextNode;	//0번 객체의 주소값에서 시작하기.
		for (int i = 0; i < index; i++) {
			node = node.nextNode;
		}
		return node;
	}

	//연결리스트에서 데이터와 다음노드 주소를 기억하는 하나의 덩어리가 됨.
	private class Node{
		private Object data;
		private Node nextNode;

		Node(Object data){
			this.data = data;
			nextNode = null;	//노드객체사  new되는 시점에 다음 노드가 미리 만들어져있지않다.
		}



	}

}