package org.example.multithreading;

import java.util.concurrent.Semaphore;

public class SemaphoreReleaseExample {
    private final Semaphore resourcePool = new Semaphore(2);

    public void accessResource() {
        try {
            resourcePool.acquire();    //Acquire a permit (there may be up to 3 available for the extra release)
            System.out.println(Thread.currentThread().getName() + " acquired a permit.");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            System.out.println(Thread.currentThread().getName() + " released a permit.");
            resourcePool.release(); //Release the permit
        }
    }

    public static void main(String[] args) {
        SemaphoreReleaseExample example = new SemaphoreReleaseExample();
        //Intentionally release a permit without acquiring it
        //This increases the number of available permits counts from 2 to 3
        example.resourcePool.release();
        System.out.println("Print count after extra release: " + example.resourcePool.availablePermits());
        //Start multiple threads with descriptive names to use the semaphore.
        for (int i = 1; i <= 3; i++) {
            new Thread(example::accessResource, "Thread-" + i).start();
        }
    }
}
