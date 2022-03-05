package com.kma.implement.streams.lambda_expression;

import java.util.Random;
import java.util.stream.Stream;

public class StreamOperator {
	public static void main(String[] args) {
		// Tạo va in ra man hinh 10 so nguyen duong khac nhau (Distinct)
		// 1.Tao ra mang ngau nhien cac so nguyen
		final Random rand = new Random();
		Stream<Integer> randoms = Stream.generate(rand::nextInt);
		randoms.filter(t -> t > 0).distinct().limit(10).forEach(t -> System.out.println(t));

	}
}
