package com.kma.implement.myarraylist;

import java.util.Iterator;

public class AppDemo {
	public static void main(String[] args) {
		KMAArraylist<String> arrNames =new KMAArraylist<String>();
		arrNames.add("Dong");
		arrNames.add("A");
		arrNames.add("B");
		arrNames.add("C");
		arrNames.add("D");
		arrNames.add("E");
		for(String st:arrNames)
			System.out.println(st);
		System.out.println("=================");
		arrNames.add(2,"F");
		for(String st:arrNames)
			System.out.println(st);
		System.out.println("=================");
		System.out.println(arrNames.get(3));
		System.out.println("=================");
		System.out.println(arrNames.remove(3));
		System.out.println("=================");
		for(String st:arrNames)
			System.out.println(st);
		System.out.println("=================");
		Iterator<String> itr = arrNames.iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next()+" ");
		}
	}
}
