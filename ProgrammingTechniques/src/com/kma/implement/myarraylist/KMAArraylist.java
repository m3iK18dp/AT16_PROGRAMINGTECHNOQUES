package com.kma.implement.myarraylist;

import java.util.Collection;
import java.util.Iterator;

public class KMAArraylist<E> implements KMAList<E> {
	public static final int INITIAL_CAPACITY = 10;

	private E[] data = (E[]) new Object[INITIAL_CAPACITY];// down-casting
	// int[] a = new int[100];

	// So luong cua cac phan tu trong list
	private int size = 0;

	// Constructors
	public KMAArraylist() {
	}

	public KMAArraylist(E[] objects) {
		for (int i = 0; i < objects.length; i++) {
			this.add(objects[i]);
		}
	}

	@Override
	public void add(int index, E e) {
		// 1. Kiem tra index co thoa man trong range cho phep hay khong
		if (index < 0 || index > this.size)
			throw new IndexOutOfBoundsException("Chi so: " + index + ", Size: " + this);
		// Change size cho mang de chuan bi insert phan tu moi vao
		changeCapacity();
		// 2. Di chuyen nhung phan tu tinh tu index
		for (int i = size - 1; i >= index; i--)
			data[i + 1] = data[i];
		// 3. Insert data
		data[index] = e;
		// 4. Tang size len 1 don vi
		this.size++;
	}

	private void changeCapacity() {
		if (this.size >= data.length) {
			E[] newData = (E[]) new Object[this.size + 1];
			System.arraycopy(this.data, 0, newData, 0, this.size);
			data = newData;
		}
	}

	@Override
	public void clear() {
		// Cach 1:
		this.data = (E[]) new Object[INITIAL_CAPACITY];
		this.size = 0;
		// cach 2: loop qua this.data va set = null all size
	}

	private void checkIndex(int index) {
		if (index < 0 || index >= this.size)
			throw new IndexOutOfBoundsException("Index out of bound...");
	}

	@Override
	public E get(int index) {
		// check invalid index
		checkIndex(index);
		return this.data[index];
	}

	@Override
	public int indexOf(Object e) {
		for (int i = 0; i < this.size; i++)
			if (this.data[i].equals(e))
				return i;
		return -1;
	}

	@Override
	public int lastIndexOf(E e) {
		for (int i = this.size - 1; i >= 0; i--)
			if (this.data[i].equals(e))
				return i;
		return -1;
	}

	@Override
	public E remove(int index) {
		checkIndex(index);
		E value = this.data[index];
		for (int i = index + 1; i < this.size; i++)
			this.data[i - 1] = this.data[i];
		this.data[this.size - 1] = null;
		this.size--;
		return value;
	}

	@Override
	public E set(int index, E e) {
		checkIndex(index);
		E value = this.data[index];
		this.data[index] = e;
		return value;
	}

	// Override iterator into Iterable
	@Override
	public Iterator<E> iterator() {
		return new KMAArrayListIterator();
	}

	// Inner class in java: mot lop trong mot lop khac
	private class KMAArrayListIterator implements Iterator<E> {
		private int currentIndex = 0;

		@Override
		public boolean hasNext() {
			return currentIndex < size;
		}

		@Override
		public E next() {
			return data[currentIndex++];
		}

		@Override
		public void remove() {
			if (currentIndex == 0)
				throw new IllegalStateException();
			KMAArraylist.this.remove(--currentIndex);
		}
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean contains(Object o) {
		for (E e : this.data)
			if (e.equals(o))
				return true;
		return false;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

}
