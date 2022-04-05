package com.kma.implement.threads.create_thread_extends_thread;

class App1 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i <= 10; i++) {
			System.out.println("Running thread 01: " + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class App2 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i <= 10; i++) {
			System.out.println("Running thread 02: " + i);
			try {
				Thread.sleep(0);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class AppImplThreadExtends {
	public static void main(String[] args) {
		App1 a = new App1();
		App2 b = new App2();
		a.start();
		b.start();
	}
}
