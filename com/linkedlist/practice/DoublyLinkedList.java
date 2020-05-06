package com.linkedlist.practice;

public class DoublyLinkedList {

	private static Node createLinkedList(int numberOfNodes) {
		
		Node head;
		Node tmp = new Node(1,null,null);
		head = tmp;
		
		for(int i=1;i<numberOfNodes;i++) {
			tmp.next = new Node(i+1,null,tmp);
			tmp=tmp.next;
		}
		
		return head;
	}
	
	private static void printDoublyLinkedList(Node head) {
		Node tmp = head;
		while (tmp != null) {
			System.out.print(tmp.data + " ");
			tmp = tmp.next;
		}
	}
	
	private static Node insertIntoDLL(Node head,int nodeVal,int position) {
		
		Node insert = null;
		
		if(head == null) {
			System.out.println("LinkedList does not exists");
			return null;
		}
		else if (position <= 0) {
			System.out.println("invalid Position");
			return null;
		}
		else if(position == 1) {
			insert = new Node(nodeVal,null,null);
			insert.next = head;
			head = insert;
		}
		else {
			insert = new Node(nodeVal,null,null);
			Node tmp = head;
			for(int i=1;i<position-1;i++) {
				tmp = tmp.next;
				if(tmp == null) {
					System.out.println("Invalid position");
					return null;
				}
			}
			
			insert.next = tmp.next;
			if(tmp.next != null)
				tmp.next.prev = insert;
			insert.prev = tmp;
			tmp.next = insert;
		}
		
		return head;
	}
	
	private static Node deleteFromDLL(Node head,int position) {

		if(head == null) {
			System.out.println("LinkedList does not exists");
			return null;
		}
		else if (position <= 0) {
			System.out.println("invalid Position");
			return null;
		}else if(position == 1) {
			head = head.next;
			head.prev = null;
		}else {
			Node tmp = head;
			for(int i=1;i<position-1;i++) {
				tmp = tmp.next;
				if(tmp.next == null) {
					System.out.println("Invalid Position");
					return null;
				}
			}
			
			tmp.next = tmp.next.next;
			
		}
		
		return head;
	}
	
	public static void main(String[] args) {
		Node head = createLinkedList(5);
		printDoublyLinkedList(head);
		
//		System.out.println(" ");
//
//		System.out.println("After Insertion");

//		head = insertIntoDLL(head, 100, 7);
//		if(head!=null)
//		printDoublyLinkedList(head);
		
		System.out.println(" ");

		System.out.println("After Deletion");
		
		head = deleteFromDLL(head, 5);
		if(head!=null)
		printDoublyLinkedList(head);
	}
	
	static class Node{
		int data;
		Node next;
		Node prev;
		
		Node(int data,Node next,Node prev){
			this.data = data;
			this.next = next;
			this.prev = prev;
		}
	}

}
