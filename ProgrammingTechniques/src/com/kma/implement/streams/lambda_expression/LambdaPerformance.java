package com.kma.implement.streams.lambda_expression;

import java.util.function.Consumer;

public class LambdaPerformance {
	public static void main(String[] args) {
		// Using Anonymous class
		System.out.println("\nAnonymous class");
		for (int i = 0; i < 5; i++) {
			Consumer<String> myPrinter1 = new Consumer<String>() {
				@Override
				public void accept(String t) {
					System.out.println("Consuming..." + t);
				}
			};
			myPrinter1.accept(myPrinter1.toString());
		}
		// Using Lambda
		for (int i = 0; i < 5; i++) {
			Consumer<String> myPrinter2 = t -> System.out.println("Consuming..." + t);
			myPrinter2.accept(myPrinter2.toString());
		}
	}
}
