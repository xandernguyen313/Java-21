package multithread;

import java.util.concurrent.Semaphore;

public class SemaphoreLockExample {
    private final Semaphore semaphore = new Semaphore(2);

    public void read() throws InterruptedException {
        semaphore.acquire();
        try {
            System.out.println("Thread " + Thread.currentThread().getName());
            Thread.sleep(2000);
        } finally {
            semaphore.release();
            System.out.println("Thread " + Thread.currentThread().getName() + " finished");
        }
    }

    public static void main(String[] args) {
        SemaphoreLockExample semaphoreLockExample = new SemaphoreLockExample();

        Thread t1 = new Thread(() -> {
            try {
                semaphoreLockExample.read();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                semaphoreLockExample.read();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();
        t2.start();
    }
}
