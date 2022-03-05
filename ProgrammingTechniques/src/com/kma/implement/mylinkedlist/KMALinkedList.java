package com.kma.implement.mylinkedlist;

public class KMALinkedList<E> extends KMAAbstractList<E> {
	// 1. Define all data fields
	private Node<E> head, tail; // head và tail để trỏ tới vùng null
	// 2. Contructor

	public KMALinkedList() {

	}

	public KMALinkedList(E[] objects) {
		super(objects);
	}

	// 3. Dinh nghia ca methods can thiet
	// 3.1 Lấy ra phần tử đầu tiên của LinkedList
	public E getFirst() {
		if (this.size() == 0)
			return null;
		else
			return this.head.element;
	}

	// 3.2 Lấy ra phần tử cuối cùng
	public E getLast() {
		if (this.size() == 0)
			return null;
		else
			return this.tail.element;
	}

	// Thêm 1 node vào vị trí đầu tiên của KMALinkedList
	public void addFirst(E e) {
		// Tao ra node để thêm vào vị trí đầu tiên
		Node<E> newNode = new Node<E>(e);
		newNode.next = head;
		this.head = newNode;
		this.size++;
		if (this.tail == null)
			this.tail = head;
	}

	// Thêm 1 node vào vị trí cuối cùng cảu LinkedList
	public void addLast(E e) {
		// Tao ra node để thêm vào vị trí đầu tiên
		Node<E> newNode = new Node<E>(e);
		if (this.tail == null)
			this.head = this.tail = newNode;
		else {
			this.tail.next = newNode;
			this.tail = newNode;
			this.size++;
		}
	}

	// Thêm data vào 1 vi trị index bất kì
	@Override
	public void add(int index, E e) {
		if (index == 0)
			this.addFirst(e);
		else if (index >= this.size)
			this.addLast(e);
		else {
			Node<E> newNode = new Node<E>(e);
			Node current = this.tail;
			for (int i = 1; i < index; i++)
				current = current.next;
			newNode.next = current.next;
			current.next = newNode;
			this.size++;
		}
	}
	// inner class => De tao ra cau truc của NODE

	private static class Node<E> {
		E element;// Data
		Node<E> next;

		public Node(E e) {
			this.element = e;
		}
	}

	@Override
	public String toString() {

		Node<E> current = this.head;
		if (this.size == 0)
			return "[]";
		else if (this.size == 1)
			return "[" + this.tail.element + "]";
		else {
			StringBuilder r = new StringBuilder("[");
			for (int i = 0; i < this.size; i++, current = current.next)
				if (current.next != null)
					r.append(current.element + "; ");
				else
					r.append(current.element + "]");
			return r.toString();
		}
	}
}
