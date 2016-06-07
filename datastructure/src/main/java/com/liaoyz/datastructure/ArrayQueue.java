package com.liaoyz.datastructure;

/**
 * 数组实现队列
 * @author n-208
 *
 */
public class ArrayQueue {
	private Object[] items;
	private int front;
	private int end;
	private int nItems;//当前队列中元素的个数
	private int SIZE = 10;

	public ArrayQueue(int size) {
		SIZE = size;
	}
	public ArrayQueue(){
		items = new Object[SIZE];
		front = 0;
		end = -1;
		nItems = 0;
	}
	/**
	 * 如果已经到数组的末尾，
	 * 需要将尾指针循环到数组的开始位置进行数据入队操作
	 * @param e
	 */
	public void insert(Object e){
		if(end == SIZE-1)
			end = -1;
		items[++end] = e;
		nItems++;
	}
	
	/**
	 * 移除
	 * @return
	 */
	public Object remove(){
        Object temp=items[front++];
        if(front==SIZE)
               front=0;
        nItems--;
        return temp;
	}
	
	public Object peekFront(){
        return items[front];
	}

 	public boolean isEmpty(){
        return (nItems==0);
 	}

 	public boolean ifFull(){
        return (nItems==SIZE);
 	}

 	public int size(){
        return nItems;
 	}

}
