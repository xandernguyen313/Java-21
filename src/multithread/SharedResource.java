package multithread;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {
    private final Queue<Integer> queue;
    private final int size;

    public SharedResource(int size){
        this.size = size;
        queue = new LinkedList<>();
    }

    public synchronized void produce(int num) throws Exception{
        while(queue.size() == size){
            wait();
        }

        queue.add(num);
        notify();
    }

    public synchronized void consume() throws Exception{
        while(queue.isEmpty()){
            wait();
        }
        int num = queue.poll();
        System.out.print(num + " ");
        notify();
    }

    public static void main(String[] args) throws InterruptedException{
        SharedResource sharedResource = new SharedResource(1);

        Thread producer = new Thread(()-> {
            try{
                for(int i = 1; i <= 10; i++){
                    sharedResource.produce(i);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        Thread consumer = new Thread(()-> {
            try{
                for(int i = 1; i <= 10; i++){
                    sharedResource.consume();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        producer.start();
        consumer.start();
    }
}
