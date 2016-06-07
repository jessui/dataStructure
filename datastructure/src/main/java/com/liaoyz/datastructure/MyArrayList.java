package com.liaoyz.datastructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * @author n-208
 *
 * @param <E>
 */
public class MyArrayList<E> implements Iterable<E> {
	
	private static final int DEFAULT_CAPACITY = 10;
	
	private int theSize;
	private E[] theItems;

	public MyArrayList() {
		clear();
	}
	
	public void clear(){
		theSize = 0;
		ensureCapacity(DEFAULT_CAPACITY);
	}
	
	public int size(){
		return theSize;
	}
	public boolean isEmpty(){
		return size() == 0;
	}
	public void trimToSize(){
		ensureCapacity(DEFAULT_CAPACITY);
	}
	public E get(int idx){
		if(idx < 0 || idx>=size())
			throw new ArrayIndexOutOfBoundsException();
		return theItems[idx];
	}
	public E set(int idx,E newVal){
		if(idx < 0 || idx>=size())
			throw new ArrayIndexOutOfBoundsException();
		E old = theItems[idx];
		theItems[idx] = newVal;
		return old;
	}
	public void ensureCapacity(int newCapacity){
		if(newCapacity<theSize)
			return;
		E[] old =theItems;
		theItems = (E[]) new Object[newCapacity];
		for(int i = 0; i<size(); i++)
			theItems[i] = old[i];
	}
	public boolean add(E e){
		add(size(),e);
		return true;
	}
	public void add(int idx, E e){
		if(theItems.length == size())
			ensureCapacity(size()*2+1);
		for(int i = theSize; i>idx; i++)
			theItems[i] = theItems[i-1];
		theItems[idx] = e;
		
		theSize++;
	}
	
	public E remove(int idx){
		E removeItem = theItems[idx];
		for(int i = 0; i<size()-1; i++)
			theItems[i] = theItems[i+1];
		
		theSize--;
		return removeItem;
	}
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new ArrayListIterator();
	}
	private class ArrayListIterator implements Iterator<E>{
		private int current = 0;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current<size();
		}

		@Override
		public E next() {
			if(!hasNext())
				throw new NoSuchElementException();
			return theItems[current++];
		}
		
		public void remove(){
			MyArrayList.this.remove(--current);
		}
		
	}
	
	
	public static void main(String[] args) {
		MyArrayList<String> list = new MyArrayList<String>();
		for(int i = 0; i<1000; i++){
			list.add("a");
		}
	}

}
