package ReaderWriter;

import java.util.Random;

public class Producer implements Runnable{
    protected MyBlockingQueue queue = null;
    private volatile boolean flag;
    private Random random;

    public Producer(MyBlockingQueue<Integer> blockingQueue) {
        this.queue = blockingQueue;
        flag = false;
        random = new Random();

    }

    /**
     * Start the producer thread
     */
    public void run() {
        while(!flag) {
            int info = random.nextInt(100);
            try {
                queue.put(info);
                System.out.println(Thread.currentThread().getName() + " produces "+ info);
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Shut down the producer
     */
    public void shutDown(){
        flag = true;
    }
}