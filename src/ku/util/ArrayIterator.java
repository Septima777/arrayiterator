package ku.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterate the element in array without knowing the structure of the array.
 * 
 * @author Noppawan Kulchol
 *
 * @param <T>
 *            The type of element that return by iterator.
 */

public class ArrayIterator<T> implements Iterator<T> {
	/** use for call remove() */
	private boolean call;
	/** The index of the element */
	private int cursor;
	/** attribute for the array we want to iterate over */
	private T[] array;

	/**
	 * Initialize a new array iterator with the array to process.
	 * 
	 * @param array
	 *            is the array to iterate over
	 */

	public ArrayIterator(T[] array) {
		this.array = array;
		this.call = false;
	}

	/**
	 * Return true or false from condition.
	 * 
	 * @return true when the iteration has more non-null elements. false
	 *         otherwise
	 */
	@Override
	public boolean hasNext() {
		for (int i = this.cursor; i < array.length; i++) {
			if (array[i] != null) {
				cursor = i;
				return true;
			}
		}
		return false;
	}

	/**
	 * Return the next non-null element from array, if any.
	 * 
	 * @return the next non-null element in the array.
	 * @throws NoSuchElementException
	 *             if there are no more elements to return.
	 */
	@Override
	public T next() {
		if (hasNext() == true) {
			cursor++;
			call = true;
			return array[cursor];
		} else
			throw new NoSuchElementException();
	}

	/**
	 * Remove element that before the last by call method next() before.
	 * 
	 * @throws IllegalStateException
	 *             it was called when you didn't call next() before.
	 * 
	 */
	@Override
	public void remove() {
		if (call == true) {
			array[cursor - 1] = null;
			call = false;
		} else
			throw new IllegalStateException();
	}

}
