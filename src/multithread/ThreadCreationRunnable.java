package multithread;

public class ThreadCreationRunnable implements Runnable {
    private static int counter = 0;
    @Override
    public void run() {
        counter++;
        System.out.println("Thread creation runnable: " + Thread.currentThread().getName());
        System.out.printf("Counter: %d\n", counter);
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadCreationRunnable());
        t1.start();
    }
}
