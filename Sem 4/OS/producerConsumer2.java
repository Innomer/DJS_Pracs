import java.util.concurrent.Semaphore;

class Buffer {
    private int[] buffer;
    private int size;
    private int in, out;
    private Semaphore mutex, empty, full;
    private int val=0;

    public Buffer(int size) {
        this.size = size;
        buffer = new int[size];
        in = out = 0;
        mutex = new Semaphore(1);
        empty = new Semaphore(size);
        full = new Semaphore(0);
    }

    public void produce(int id) throws InterruptedException {
        empty.acquire();
        mutex.acquire();   
        buffer[in] = (val++);
        System.out.println("Producer "+id+" produced " + buffer[in]);
        in = (in + 1) % size;
        mutex.release();
        full.release();
    }

    public void consume(int id) throws InterruptedException {
        full.acquire();
        mutex.acquire();
        int item = buffer[out];
        val--;
        System.out.println("Consumer "+id+" consumed " + item);
        out = (out + 1) % size;
        mutex.release();
        empty.release();
    }
}

class Producer extends Thread {

    int id=1;

    public Producer(int id) {
    this.id = id;
    }

    synchronized public void run() {
        Buffer buffer = producerConsumer2.buffer;
        int i;
        try {
            synchronized (this) {
                while(true) {
                    buffer.produce(id);
                    Thread.sleep((int) (Math.random() * 2000));
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer extends Thread {

    int id=1;

    public Consumer(int id) {
    this.id = id;
    }

    public void run() {
        try {
            synchronized (this) {
                Buffer buffer = producerConsumer2.buffer;
                while(true) {
                    buffer.consume(id);
                    Thread.sleep((int) (Math.random() * 2000));
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class producerConsumer2 {
    public static Buffer buffer = new Buffer(5);

    public static void main(String[] args) {
        Producer producerThread = new Producer(1);
        Producer producerThread1 = new Producer(2);
        Consumer consumerThread = new Consumer(1);
        producerThread.start();
        producerThread1.start();
        consumerThread.start();
        try {
            producerThread.join();
            producerThread1.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
