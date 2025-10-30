package multithread;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolExample extends RecursiveTask<Long> {
    private final int[] arr;
    private final int start;
    private final int end;

    public ForkJoinPoolExample(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int size = end - start;

        // threshold: do it directly if the chunk is small
        if (size <= 1000) {
            long sum = 0L;
            for (int i = start; i < end; i++) {
                sum += arr[i];
            }
            return sum;
        } else {
            // split in half
            int mid = (start + end) / 2;

            ForkJoinPoolExample left = new ForkJoinPoolExample(arr, start, mid);
            ForkJoinPoolExample right = new ForkJoinPoolExample(arr, mid, end);

            // fork one half asynchronously
            left.fork();

            // compute the other half in the current thread
            long rightResult = right.compute();

            // wait for the forked half
            long leftResult = left.join();

            return leftResult + rightResult;
        }
    }

    public static void main(String[] args) {
        int n = 100_000_000;
        int[] data = new int[n];
        Random rnd = new Random(123); // fixed seed for repeatable result
        long expected = 0L;
        for (int i = 0; i < n; i++) {
            data[i] = rnd.nextInt(100); // 0..99
            expected += data[i];
        }


        // 2. Create the root task for the whole range
        ForkJoinPoolExample root = new ForkJoinPoolExample(data, 0, data.length);

        // 3. Create a ForkJoinPool (you can also use ForkJoinPool.commonPool())
        ForkJoinPool pool = new ForkJoinPool();

        // 4. Invoke the task (this blocks until result is ready)
        long result = pool.invoke(root);

        // 5. Show results
        System.out.println("ForkJoinPool sum  = " + result);
        System.out.println("Expected (manual) = " + expected);
        Long sum = 0L;
        for(int num : data){
            sum += num;
        }
        System.out.println("sum  = " + sum);
    }
}
