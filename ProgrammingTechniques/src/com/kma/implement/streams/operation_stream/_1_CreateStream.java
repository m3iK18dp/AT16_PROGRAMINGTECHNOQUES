package com.kma.implement.streams.operation_stream;

import java.util.Collection;
import java.util.LinkedList;
import java.util.stream.Stream;

import com.kma.implement.streams.lambda_expression.Employee;

public class _1_CreateStream {

	public static void main(String[] args) {
		// 1. Tao stream thong qua phuong thuc tinh cua stream class
		Stream<Integer> seqNumber = Stream.of(1, 2, 4, 5, 12, 6, 7, 23, 5, 2, 54);
		// 2. printer
		// seqNumber.forEach(number -> System.out.println(number));
		seqNumber.forEach(System.out::println);
		System.out.println("======================");
		// 3. Tao stream tu 1 mang tinh
		Employee[] emps = { new Employee(1, "Dong", 10), new Employee(2, "Hoang", 11), new Employee(3, "Dung", 12),
				new Employee(4, "Bao", 13), new Employee(5, "Khanh", 14), new Employee(6, "Kiem", 15), };
		Stream<Employee> empStream = Stream.of(emps);
		empStream.forEach(System.out::println);
		System.out.println("======================");
		// 4. Tao stream tu collections (List, set, map...)
		Collection<Employee> empCol = new LinkedList<Employee>();
		empCol.add(new Employee(1, "Dong", 10));
		empCol.add(new Employee(2, "Hoang", 11));
		empCol.add(new Employee(3, "Kiem", 12));
		Stream<Employee> empColStream = empCol.stream();
		// Operations on
		empColStream.forEach(System.out::println);
	}

}
