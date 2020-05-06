package com.linkedlist.practice;

public class CircularLinkedList {

	private static Node createCircularLinkedList(int number) {
		Node tail = null;
		Node tmp = new Node(1, null);
		tail = tmp;
		tmp.next = tail;
		Node head = tail;

		for (int i = 1; i < number; i++) {
			tmp = new Node(i + 1, head);
			tail.next = tmp;
			tail = tmp;
		}

		return tail;
	}

	private static Node insertIntoCSLL(Node tail, int nodeVal, int position) {

		// Check if linked list exists
		if (tail == null) {
			System.out.println("Linked List does not exists");
		}

		if (position <= 0) {
			System.out.println("Invalid position");
			return null;
		}

		Node insert = new Node(nodeVal, null);

		Node move = tail.next;

		// If it is the first position
		if (position == 1) {
			insert.next = move;
			tail.next = insert;
		} else { // insert in between or at the end of the list
			for (int i = 1; i < position - 1;) {
				move = move.next;
				if (move == tail.next) {
					System.out.println("Invalid Position");
					return null;
				}
				i++;
			}

			insert.next = move.next;
			move.next = insert;
			if (move == tail) {
				tail = insert;
			}
		}

		return tail;

	}

	private static Node deleteFromCSLL(Node tail, int position) {
		// Check if linked list exists
		if (tail == null) {
			System.out.println("Linked List does not exists");
		}

		if (position <= 0) {
			System.out.println("Invalid position");
			return null;
		}

		Node move = tail.next;

		// If it is the first position
		if (position == 1) {
			tail.next = move.next;
			move = move.next;
		} else {
			for (int i = 1; i < position - 1;) {
				move = move.next;
				if (move == tail) {
					System.out.println("Invalid Position");
					return null;
				}
				i++;
			}

			if (move.next == tail) {
				tail = move;
			}

			move.next = move.next.next;
			// move.next.next = null;
		}

		return tail;
	}

	private static void printCircularLinkedList(Node tail) {
		Node tmp = tail.next;
		while (tmp != tail) {
			System.out.print(tmp.data + " ");
			tmp = tmp.next;
		}
		System.out.print(tail.data);
	}

	public static void main(String[] args) {
		Node tail = createCircularLinkedList(5);
		printCircularLinkedList(tail);

		System.out.println(" ");

		System.out.println("After Insertion");

		/***
		 * Before execution please comment the non required logic
		 **/

		// Insertion Logic
		tail = insertIntoCSLL(tail, 100, 2);
		printCircularLinkedList(tail);

		// Insertion Logic
		tail = insertIntoCSLL(tail, 100, 1);
		printCircularLinkedList(tail);

		// Insertion Logic
		tail = insertIntoCSLL(tail, 100, 6);
		printCircularLinkedList(tail);

		tail = insertIntoCSLL(tail, 100, 7);
		if (tail != null)
			printCircularLinkedList(tail);

		/***
		 * Before execution please comment the non required logic
		 **/
		// Deletion
		tail = deleteFromCSLL(tail, 1);
		if (tail != null)
			printCircularLinkedList(tail);

		tail = deleteFromCSLL(tail, 4);
		if (tail != null)
			printCircularLinkedList(tail);

		tail = deleteFromCSLL(tail, 5);
		if (tail != null)
			printCircularLinkedList(tail);

		tail = deleteFromCSLL(tail, 6);
		if (tail != null)
			printCircularLinkedList(tail);
	}

	public static class Node {
		int data;
		Node next;

		Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
}
