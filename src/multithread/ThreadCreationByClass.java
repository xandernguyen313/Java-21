package multithread;

public class ThreadCreationByClass extends Thread {
    @Override
    public void run() {
        System.out.println("Thread creation runnable: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread t1 = new ThreadCreationByClass();
        t1.start();
    }
}
