package multithread;

import java.util.concurrent.locks.ReentrantReadWriteLock;

// Read + Read Lock is okay
// Read + Write is not
// Write + Write is not
// Good for applications that requires alot of reading but few writes
public class ReadWriteLock {

    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void read(){
        lock.readLock().lock();
        try{
            System.out.println("Thread " + Thread.currentThread().getName() + " is reading");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally{
            lock.readLock().unlock();
            System.out.println("Thread " + Thread.currentThread().getName() + " is done reading");
        }
    }

    public void write(){
        lock.writeLock().lock();
        try{
            System.out.println("Thread " + Thread.currentThread().getName() + " is writing");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally{
            lock.writeLock().unlock();
            System.out.println("Thread " + Thread.currentThread().getName() + " is done writing");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        ReadWriteLock resource = new ReadWriteLock();
        Thread readThread1 = new Thread(() -> {
            resource.read();
        });
        Thread readThread2 = new Thread(() -> {
            resource.read();
        });
        Thread readThread3 = new Thread(() -> {
            resource.write();
        });

        readThread3.start();
        readThread1.start();
        readThread2.start();
    }
}
