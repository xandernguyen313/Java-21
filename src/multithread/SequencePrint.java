package multithread;

import java.util.concurrent.locks.ReentrantLock;

public class SequencePrint {
    private final int max = 10;
    private int counter = 1;
    private final ReentrantLock lock = new ReentrantLock();
    public void print(int targetRemainder){
        while(true){
            lock.lock();
            try{
                if(counter > max){
                    break;
                }
                if(counter % 3 == targetRemainder){
                    System.out.println(Thread.currentThread().getName() + " : " + counter);
                    counter++;
                }
            } finally{
                lock.unlock();
            }


        }
    }

    public static void main(String[] args) throws InterruptedException {
        SequencePrint print = new SequencePrint();
        Thread t1 = new Thread(()-> print.print(1), "T1");
        Thread t2 = new Thread(()-> print.print(2), "T2");
        Thread t3 = new Thread(()-> print.print(0), "T3");
        t1.start();
        t2.start();
        t3.start();
    }
}
