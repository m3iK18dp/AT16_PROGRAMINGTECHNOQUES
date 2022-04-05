package com.kma.implement.threads.parallelprograming;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class FindMaxElement {
	public static void main(String[] args) {
		// 1. Create a array (static)
		final int NUM_OF_ELEMENT = 90_000_000;
		int[] list = new int[NUM_OF_ELEMENT];
		for (int i = 0; i < list.length; i++) {
			list[i] = (int) (Math.random() * 90000000) + 1;
		}
		long startTime = System.currentTimeMillis();
		System.out.println("Gia tri max la: " + getMaxNumber(list));
		long endTime = System.currentTimeMillis();
		System.out.println("So luong processors la: " + Runtime.getRuntime().availableProcessors());
		System.out.println("Thoi gian hoan thanh tim max: " + (endTime - startTime));

	}

	private static int getMaxNumber(int[] list) {
		RecursiveTask<Integer> t = new Max(list, 0, list.length);
		ForkJoinPool pool = new ForkJoinPool();
		return pool.invoke(t);
	}

	private static class Max extends RecursiveTask<Integer> {
		// nguong
		private final static int THRESHOLD = 1000;
		private int[] list;
		private int low;
		private int high;

		public Max(int[] list, int low, int high) {
			this.list = list;
			this.low = low;
			this.high = high;
		}

		@Override
		protected Integer compute() {
			if (high - low < THRESHOLD) {
				int max = list[0];
				for (int i = low; i < high; i++)
					if (list[i] > max)
						max = list[i];
				return max;
			} else {
				int mid = (low + high) / 2;
				RecursiveTask<Integer> left = new Max(list, low, mid);
				RecursiveTask<Integer> right = new Max(list, mid, high);
				right.fork();
				left.fork();
				// join cac fork lai
				return new Integer(Math.max(left.join().intValue(), right.join().intValue()));
			}
		}

	}
}
