package org.example.multithreading;

import java.util.concurrent.Semaphore;

public class CountingSemaphoreExample {
    private static final Semaphore resourcePool = new Semaphore(5);  //semaphore with 5 permits

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            final int threadNum = i;
            Thread t = new Thread(() -> accessResource("Thread-" + threadNum));
            t.start();
        }
    }

    private static void accessResource(String threadNum) {
        try {
            System.out.println(threadNum + " is attempting to acquire a permit.");
            resourcePool.acquire(); //acquire a permit
            System.out.println(threadNum + " has acquired a permit.");
            Thread.sleep(2000); //simulate resource usage
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            resourcePool.release(); //release the permit
            System.out.println(threadNum + " has released a permit.");
        }
    }
}
