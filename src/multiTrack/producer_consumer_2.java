package multiTrack;


import java.util.LinkedList;
import java.util.Queue;


public class producer_consumer_2 {
    public static void main(String[] args) throws InterruptedException {
        ProduserConsumer pc = new ProduserConsumer();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consumer();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

    }
}

class ProduserConsumer{
    private static  Queue<Integer> queue = new LinkedList<>();
    private static final int LIMIT= 10; //  максимальное значение очереди
    private static final Object lock = new Object();

    // создаем производителя, тоесть тот кто добавляет данные в поток
    public static void produce() throws InterruptedException {
        int value = 0;
        while (true){
            synchronized (lock){
                while (queue.size() == LIMIT){
                    lock.wait();
                }
                queue.offer(value++);
                lock.notify();
            }
        }
    }
    public static void consumer() throws InterruptedException {
        while (true){
            synchronized (lock){
                while (queue.size() == 0){
                    lock.wait();
                }
                int value = queue.poll();
                System.out.println(value);
                System.out.println("Queue size is: " + queue.size());
                lock.notify();
            }
            Thread.sleep(1000);
        }
    }
}
