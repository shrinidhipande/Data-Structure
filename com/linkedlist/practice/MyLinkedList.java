package com.linkedlist.practice;

public class MyLinkedList {

	Node head = null;
	Node tail = null;

	public Node createLinkedList(int noOfNodes) {

		Node n = new Node(0, null);
		head = n;
		tail = n;

		for (int i = 1; i < noOfNodes; i++) {
			n = new Node(i, null);
			tail.next = n;
			tail = n;
		}

		return head;
	}

	public Node insertNode(Node head, int position, int data) {

		if(head == null) {
			System.out.println("Linked list does not exist");
			return null;
		}
		
		if (position < 0) {
			System.out.println("Invalid Position");
		}

		Node node = new Node(data, null);

		if (position == 1) {
			node.next = head;
			head = node;
		} else {
			int i=1;
			Node temp = head;
			while(i<position-1) {
				temp = temp.next;
				if(temp == null) {
					System.out.println("Invalid Position");
					return head;
				}
				i++;
			}
			node.next = temp.next;
			temp.next = node;
		}
		
		return head;

	}

	public Node deleteNode(Node head, int position) {

		if (head == null) {
			System.out.println("Linked list does not exist");
			return null;
		}

		if (position < 1) {
			System.out.println("Invalid Position");
			return head;
		}
		
		Node temp = head;
		
		if(position == 1) {
			head = head.next;
			temp.next = null;
		}
		
		int i=1;
		
		while(i < position-1) {
			temp = temp.next;
			if(temp == null || temp == tail) {
				System.out.println("invalid position");
				return head;
			}
			i++;
		}
		
		Node deleting = temp.next;
		
		temp.next = deleting.next;
		deleting.next = null;
		return head;		
	}
	
	public void printLinkedList(Node n) {
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
	}

}

class Node {
	int data;
	Node next;

	Node(int data, Node ref) {
		this.data = data;
		this.next = ref;
	}
}
