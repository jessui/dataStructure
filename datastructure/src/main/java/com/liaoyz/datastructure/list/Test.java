package com.liaoyz.datastructure.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Test {

	public static void removeEvensVerl(List<Integer> lst){
		long start = System.currentTimeMillis();
		int i = 0;
		while(i<lst.size()){
			if(lst.get(i)%2 == 0){
				lst.remove(i);
			}else{
				i++;
			}
		}
		long end = System.currentTimeMillis();
		long time = end-start;
		System.out.println("====耗时===="+time);
	}
	
	public static void removeEvensVerl1(List<Integer> lst){
		long start = System.currentTimeMillis();
		for(Integer i : lst){
			if(i%2 == 0)
				lst.remove(i);
		}
		long end = System.currentTimeMillis();
		long time = end-start;
		System.out.println("======耗时1====="+time);
	}
	
	public static void removeEvensVerl2(List<Integer> lst){
		long start = System.currentTimeMillis();
		Iterator<Integer> ite = lst.iterator();
		while(ite.hasNext()){
			if(ite.next() % 2 == 0){
				ite.remove();
			}
		}
		long end = System.currentTimeMillis();
		long time = end-start;
		System.out.println("======耗时2====="+time);
	}
	
	public static List<Integer> productList(List<Integer> list, int maxNum,int count){
		Random r = new Random();
		int i = 0;
		while(i<count){
			int nextNum = r.nextInt(maxNum);
			list.add(nextNum);
			i++;
		}
		return list;
	}
	
	public static void main(String[] args) {
		List<Integer> arrayList = new ArrayList<Integer>();
		productList(arrayList, 100000000, 400000);
		List<Integer> linkList = new LinkedList<Integer>(arrayList);
		//removeEvensVerl2(arrayList);
		removeEvensVerl2(linkList);
	}

}
