package com.kma.implement.streams.methodreference;

import java.util.function.Supplier;

import com.kma.implement.streams.lambda_expression.Employee;

public class MethdReference {
	public static void main(String[] args) {
		Employee e = new Employee(1, "Vu Dao", 1500);
		// Lấy ra lương của e
		Double salary = e.getSalary();
		System.out.println(salary);
		System.out.println("==================");
		// dùng method reference

		Supplier<Double> salary2 = e::getSalary;
		System.out.println(salary2.get());
		// dùng method reference->lớp tĩnh
		Supplier<Double> salaryStatic = Employee::getStaticSalary;
		System.out.println(salaryStatic.get());
	}
}
