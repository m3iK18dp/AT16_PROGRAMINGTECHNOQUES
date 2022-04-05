package com.kma.implement.threads.cooperation_threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CooperationThread {
	private static Account account = new Account();

	public static void main(String[] args) {
//1. Tao ra pool gom 2 threads
		ExecutorService ex = Executors.newFixedThreadPool(2);
//2. add thread vào
		ex.execute(new Deposit());
		ex.execute(new Withdraw());
		ex.shutdown();
		System.out.println("Da luong dang chay...");
	}

	// 1 Thuc hien deposit (task)
	public static class Deposit implements Runnable {

		@Override
		public void run() {
			try {
				while (true) {
					account.deposit((int) (Math.random() * 200) + 1);
					Thread.sleep(1000);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// 2 thục hien withdraw (task)
	public static class Withdraw implements Runnable {
		@Override
		public void run() {
			while (true) {
				account.withdraw((int) (Math.random() * 200) + 1);
			}
		}
	}

	private static class Account {
		// De dong bo viec gui tien
		private static Lock lock = new ReentrantLock();
		// tao ra dieu kien condition
		private static Condition newDeposit = lock.newCondition();
		private int balance = 0;

		public int getBalance() {
			return this.balance;
		}

		public void withdraw(int amount) {
			lock.lock();
			try {
				while (balance < amount) {
					System.out.println("Hay doi du tien da roi hay rut...!");
					newDeposit.await();
				}
				this.balance -= amount;
				System.out.println("Da rut so tien " + amount + "\t\t" + this.getBalance());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}

		public void deposit(int amount) {
			lock.lock();
			try {
				this.balance += amount;
				System.out.println("Da nop tien " + amount + "\t\t" + this.getBalance());
				// kich hoat (signal) thread ma dang doi o cho condition
				newDeposit.signalAll();
			} finally {
				lock.unlock();
			}
		}
	}
}
