package ReaderWriter;

import java.util.LinkedList;
import java.util.Queue;

/**
 * A blocking queue implemented by self that allows add and get ops
 * Thread-safe for multi-thread
 * @param <T>
 */
public class MyBlockingQueue<T> {

    private Queue<T> queue;
    private int limit;


    public MyBlockingQueue(int size) {
        this.limit = size;
        queue = new LinkedList<T>();
    }

    /**
     *  Add operation for the queue, only one thread could add this queue at a time
     * @param task: Generic Constructor
     * @throws InterruptedException
     */

    public synchronized void put(T task) throws InterruptedException {
        while (this.queue.size() == this.limit) {
            wait();
        }

        if (this.queue.size() == 0) {
            notifyAll();
        } else {
            notify();
        }

        queue.add(task);
    }

    /**
     * Poll operation for the queue, only one thread could poll this queue at a time
     * @return
     * @throws InterruptedException
     */
    public synchronized T take() throws InterruptedException {
        while (this.queue.size() == 0){
            wait();
        }

        if (this.queue.size() == this.limit) {
            notifyAll();
        }

        return this.queue.remove();
    }
}
