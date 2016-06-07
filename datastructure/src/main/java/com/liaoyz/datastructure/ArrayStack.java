package com.liaoyz.datastructure;

/**
 * 数组实现栈
 * @author n-208
 *
 */
public class ArrayStack {
	
	private Object[] stack;
	private int top;//标记下一个入栈的位置，同时也是栈的大小
	private int SIZE = 10;

	public ArrayStack() {
		stack = new Object[SIZE];
		top = 0;
	}
	public void expand(){//扩充空间
		Object[] larger = new Object[size()*2];
		for(int i = 0; i<top ;i++){
			larger[i] = stack[i];
		}
		stack = larger;
	}
	public int size(){
		return top;
	}
	public boolean isEmpty(){
		return size() == 0;
	}
	public void push(Object e){
		if(top == stack.length){
			expand();
		}
		stack[top] = e;
		top++;//下一个入栈位置
	}
	public Object pop(){
		if(isEmpty()){
			System.out.println("isempty");
			return null;
		}
		top--;
		Object result = stack[top];
		stack[top] = null;
		
		return result;
	}
	public Object peek(){
		Object result;
		if(isEmpty())
			result = null;
		result = stack[top-1];
		return result;
	}

}
