package multithread;

import java.util.concurrent.*;

public class ThreadPoolExecutorExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(3);
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                2, 4, 1000, TimeUnit.SECONDS, workQueue
        );

//        for(int i = 0; i < 5; i++) {
//            pool.submit(() -> {
//                System.out.println(Thread.currentThread().getName() + " start");
//                try{
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//
//                }
//                System.out.println(Thread.currentThread().getName() + " end");
//            });
//        }
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Thread " + Thread.currentThread().getName() + " start");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "World!";
        });

        System.out.println(future.isDone());
        System.out.println("Not Completed");
        // Accept does not return any value
        // thenAccept consumes the value returned from another future
        CompletableFuture<Void> acceptFuture = future.thenAccept((String s) -> {
            System.out.println("Hello " + s);
        });

        // Compose consumes and returns another CompletableFuture
        // composeAsync asks for another thread from threadpool
        // compose uses the same thread from previous future
        CompletableFuture<String> finalFuture = future.thenComposeAsync((String s) -> {
            System.out.println("Thread " + Thread.currentThread().getName() + " start");
            System.out.println("s : " + s);
            return CompletableFuture.completedFuture("Hello " + s);
        });
        System.out.println(finalFuture.get());
        System.out.println(acceptFuture.get());
        pool.shutdown();
    }
}
