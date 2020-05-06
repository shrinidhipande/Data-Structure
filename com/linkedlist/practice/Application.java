package com.linkedlist.practice;

public class Application {

	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		Node n = list.createLinkedList(5);
		list.printLinkedList(n);
		
		System.out.println();
		
//		Node ins = list.insertNode(n, 7, 100);
//		list.printLinkedList(ins);
		
		Node del = list.deleteNode(n,5);
		list.printLinkedList(del);

	}

}
