package ReaderWriter;

public class Consumer implements Runnable{

    protected MyBlockingQueue queue = null;
    private volatile boolean flag;

    public Consumer(MyBlockingQueue<Integer> blockingQueue) {
        this.queue = blockingQueue;
    }

    /**
     * Start the customer thread
     */
    public void run() {
        while (!flag) {
            int info;
            try {
                info = (int)queue.take();
                System.out.println(Thread.currentThread().getName() + " consumes "+ info);
                Thread.sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Shut down the customer
     */
    public void shutDown() {
        flag = true;
    }
}
