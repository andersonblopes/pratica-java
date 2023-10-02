package com.lopes.threads;

public class TestThreads {

	public static void main(String[] args) {
		new Thread(t1).start();
		new Thread(t2).start();
		new Thread(t3).start();
		new Thread(t4).start();
	}

	private static Runnable t1 = new Runnable() {

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				System.out.println("Thread t1: " + i);
			}
		}
	};

	private static Runnable t2 = new Runnable() {

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				System.out.println("Thread t2: " + i);
			}
		}
	};

	private static Runnable t3 = new Runnable() {

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				System.out.println("Thread t3: " + i);
			}
		}
	};

	private static Runnable t4 = new Runnable() {

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				System.out.println("Thread t4: " + i);
			}
		}
	};

}
