package com.algo;

import java.util.LinkedList;
import java.util.ListIterator;;
public class Iterator {

	public static void main(String[] args) {
		int n = 10;	//전체 병사의 수
		int k = 3; 	//건너뛰는 횟수
		LinkedList<Integer> list = new LinkedList<>();
		
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}
		int jumpCount = 1;
		while(list.size()>(k-1)) {
			//리스트 반복자(순회자)
			ListIterator<Integer> iterator = list.listIterator();
			
			while(iterator.hasNext()) {
				int x= iterator.next();
				if(jumpCount%k==0) {	//3번 뛰었을 때마다해당 병사 삭제.
					System.out.println(x+"삭제함");
					iterator.remove();
				}
				jumpCount++;	//점프 횟수
			}
		}
		System.out.println("남은 번호: " + list.toString());
	}
	

}
