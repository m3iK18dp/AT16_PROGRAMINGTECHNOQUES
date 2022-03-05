package com.kma.implement.myarraylist;

import java.util.Collection;

public interface KMAList<E> extends Collection<E> {
	// Add a new element into Array
	public void add(int index, E e);

	// Return a elememnt from the list at the specified index
	public E get(int index);

	/* Return the index of the element, Return -1 if not found */
	public int indexOf(Object e);

	public int lastIndexOf(E e);

	// Remove the element at the position specified
	public E remove(int index);

	// Replace the element at the specified
	public E set(int index, E e);

	// Add a new element
	@Override
	public default boolean add(E e) {
		add(size(), e);
		return true;
	}

	// Return true if the list contains no element
	@Override
	public default boolean isEmpty() {
		return this.size() == 0;
	}

	// remove all data in myarraylist
	@Override
	public void clear();

	// Remove the first has been...
	@Override
	public default boolean remove(Object e) {
		if (indexOf(e) >= 0) {
			remove(indexOf(e));
			return true;
		} else
			return false;
	}
}
