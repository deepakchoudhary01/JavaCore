package org.example.multithreading;

import java.util.concurrent.*;

public class SemaphoreBarrierExecutorDemo {
    //A reusable barrier implemented with semaphores
    static class SemaphoreBarrier {
        private final int parties;
        private int count;
        private final Semaphore mutex = new Semaphore(1);
        private final Semaphore barrier = new Semaphore(0);

        SemaphoreBarrier(int parties) {
            this.parties = parties;
            this.count = parties;
        }

        public void await() throws InterruptedException {
            mutex.acquire();
            count--;
            if (count == 0) {
                //Last thread arrives: release all waiting threads
                mutex.release(parties - 1);
                //Reset barrier state for reuse
                count = parties;
                mutex.release();
            } else {
                //Release mutex so other threads can update the count
                mutex.release();
                //Wait until the last thread releases this thread
                barrier.acquire();
            }
        }
    }

    public static void main(String[] args) {
        final int numThreads = 5;
        final SemaphoreBarrier barrier = new SemaphoreBarrier(numThreads);
        //Create a fixed thread pool with custom thread names
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads, new ThreadFactory() {
            private int counter = 1;

            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r, "Worker-" + counter);
                counter++;
                return t;
            }
        });

        //Submit tasks to the executor
        for (int i = 0; i < numThreads; i++) {
            executorService.submit(() -> {
                try {
                    //Phase 1: Some work before reaching the first barrier
                    System.out.println(Thread.currentThread().getName() + " is processing phase 1.");
                    Thread.sleep((long) (Math.random() * 1000)); //Simulate work
                    System.out.println(Thread.currentThread().getName() + " arrived at barrier after phase 1.");
                    barrier.await();    //waits until all threads reach here
                    //Phase 2: This phase begins only after every thread has finished phase 1
                    System.out.println(Thread.currentThread().getName() + " is processing phase 2.");
                    Thread.sleep((long) (Math.random() * 1000)); //Simulate work
                    System.out.println(Thread.currentThread().getName() + " finished phase 2.");
                    barrier.await();    //Synchronize end of phase 2
                    //Phase 3: This phase begins only after every thread has completed phase 2
                    System.out.println(Thread.currentThread().getName() + " is processing phase 3.");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println(Thread.currentThread().getName() + " was interrupted.");
                }
            });
        }

        //Initiate an orderly shutdown
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(30, TimeUnit.SECONDS)) {
                System.out.println("Some tasks did not finish in time");
                executorService.shutdown();
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
            executorService.shutdown();
        }
        System.out.println("All tasks completed.");
    }
}
