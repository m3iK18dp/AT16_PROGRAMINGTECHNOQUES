package com.kma.implement.streams.purefunction;

public class PureFunction {
	/*
	 * +Requirement: Cho một mảng chứa các số int, tính tổng các số nguyên trong
	 * mảng với điều kiện: - Không sử dụng vòng lặp - Không khai báo thên biến
	 */
	public static int sum(int[] data, int l) {
		if (l >= data.length - 1)
			return data[data.length - 1];
		return sum(data, l + 1) + data[l];
	}

	public static void main(String[] args) {
		int[] data = { 1, 2, 3, 4, 5, 6 };
		System.out.println(sum(data, 0));
	}
}
