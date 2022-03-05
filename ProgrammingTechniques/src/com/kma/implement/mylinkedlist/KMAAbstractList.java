package com.kma.implement.mylinkedlist;

import java.util.Collection;
import java.util.Iterator;

import com.kma.implement.myarraylist.KMAList;

public class KMAAbstractList<E> implements KMAList<E> {
	protected int size = 0;

	public KMAAbstractList() {

	}

	public KMAAbstractList(E[] objects) {
		for (int i = 0; i < objects.length; i++)
			this.add(this.size, objects[i]);
	}

	@Override
	public boolean add(E e) {
		this.add(size, e);
		return true;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean remove(Object e) {
		// 1. Lấy vị trí của phần tử muốn remove
		int pos = this.indexOf(e);
		if (pos >= 0) {
			this.remove(pos);
			return true;
		}
		return false;
	}

	@Override
	public boolean contains(Object o) {
		return this.indexOf(o) >= 0;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
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

	@Override
	public void add(int index, E e) {
		// TODO Auto-generated method stub

	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(E e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E set(int index, E e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}
}
