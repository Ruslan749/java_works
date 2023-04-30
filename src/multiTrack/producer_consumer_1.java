/*
            патерн производитель потребитель при помощи пакета current (используеться в большинстве случаев)
    produce()--- заполняет очередь элиментами (ограничения до 10 элиментов) и ждет пока эта очередть не освободиться
    consumer() --- вытаскивает элимент из очереди и обрабатывает его, если очередь пуста то ждет когда элименты попадут в очередь
*/
package multiTrack;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class producer_consumer_1 {
    // очередь котора потока безовпасная и ограничен размер
    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consumer();
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
    // создаем производителя, тоесть тот кто добавляет данные в поток
    private static void produce() throws InterruptedException {
        Random random = new Random();
        while (true){
            // метод put  ждет пока очередь не освободиться если нет больше в ней места
            queue.put(random.nextInt(100));
        }
    }
    private static void consumer() throws InterruptedException {
        Random random = new Random();
        while (true){
            Thread.sleep(100);

            if (random.nextInt(10) == 5){
                // метод take  ждет пока  в очереди не появиться элимент
                System.out.println(queue.take());
                System.out.println("Queue size: " + queue.size());
            }

        }
    }
}
