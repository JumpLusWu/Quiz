package ReaderWriter;

public class QueueExample {
    public static void main(String[] args) {
        MyBlockingQueue<Integer> queue = new MyBlockingQueue(Integer.MAX_VALUE);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        for (int i = 0; i < 10; i++) {
            if (i < 5) {
                new Thread(producer, "producer" + i).start();
            } else {
                new Thread(consumer, "consumer" + (i - 5)).start();
            }
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        producer.shutDown();
        consumer.shutDown();
    }
}
