import java.util.LinkedList;

class Producer extends Thread{
    // LinkedList<Integer> list = new LinkedList<>();
    // public Producer(LinkedList<Integer> l){
    //     list=l;
    // }
    
    public void produce() throws InterruptedException {
        int flag=0;
        while (true) {
            int value = producerConsumer.val;
            synchronized (this) {
                while (producerConsumer.list.size() == producerConsumer.capacity)
                {
                    System.out.println("waitin P");
                    // notify()
                    // wait();
                    Thread.sleep(1000);
                    // flag=1;
                    // break;
                }
                if(flag==1){
                    break;
                }
                System.out.println("Producer produced-"
                        + value);

                producerConsumer.list.add(value++);

                notifyAll();
                // join();
                Thread.sleep(1000);
            }
        }
    }

    synchronized public void run(){
        try {
            produce();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

class Consumer extends Thread{
    // LinkedList<Integer> list = new LinkedList<>();

    // public Consumer(LinkedList<Integer> l){
    //     list=l;
    // }

     public void consume() throws InterruptedException {
        int flag=0;
        while (true) {
            synchronized (this) {

                while (producerConsumer.list.size() == 0){
                    // flag=1;
                    // break;
                    System.out.println("waitin Consumer");
                    // wait();
                    Thread.sleep(1000);
                }
                if(flag==1){
                    break;
                }
                    // wait();
                    // break;

                producerConsumer.list.removeFirst();

                System.out.println("Consumer consumed-"
                        + producerConsumer.val);

                producerConsumer.val=0;

                notifyAll();
                // join();
                Thread.sleep(1000);
            }
        }
    }
    synchronized public void run(){
        try {
            consume();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

public class producerConsumer {
    
    public static LinkedList<Integer> list = new LinkedList<>();
    public static int capacity=2;
    public static int val=0;
    public static void main(String[] args) throws InterruptedException {
        Consumer c=new Consumer();
        Producer p=new Producer();
        Producer p1=new Producer();
        c.start();
        p.start();
        p1.start();
        // p.join();
        // c.join();
    }
}
