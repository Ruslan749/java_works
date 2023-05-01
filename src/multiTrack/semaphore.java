/*
тогда когда у нас есть один ресурс и много потоков используют этот ресурс,
и мы хотим ограничить доступ к этому ресурсу
        semaphore.release(); --- отдает разрешение (тогда когда заканчиваем использование потока)
        semaphore.acquire(); --- в том случае когда начинаем взаимодействие с ресурсом;
        semaphore.availablePermits(); --- количество разрешений которое нам доступно
 */
package multiTrack;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class semaphore {
    public static void main(String[] args) throws InterruptedException {
//        Semaphore semaphore = new Semaphore(3); // число количество разрешений для потоков
//
//        try {
//            semaphore.acquire();
//            semaphore.acquire();
//            semaphore.acquire();
//
//            System.out.println("все потоки заняты");
//
//            semaphore.acquire();
//            System.out.println(" то что не выведеться из за загружености потоков");
//
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        semaphore.release();
//
//        System.out.println(semaphore.availablePermits()); // количество разрешений которое нам доступно
        ExecutorService executorService = Executors.newFixedThreadPool(200);
        Connection connection = Connection.getConnection();
        for (int i = 0; i < 200; i++){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        connection.work();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
    }
}

class Connection{
    private static Connection connection = new Connection();
    private int connectionsCount;
    private Semaphore semaphore = new Semaphore(10);
    private Connection (){

    }

    public static Connection getConnection() {
        return connection;
    }

    public void work() throws InterruptedException {
        semaphore.acquire();
        doWork();
        semaphore.release();
    }

    public void doWork() throws InterruptedException {
        synchronized (this){
            connectionsCount++;
            System.out.println(connectionsCount);
        }
        Thread.sleep(5000);

        synchronized (this){
            connectionsCount--;
        }
    }
}
