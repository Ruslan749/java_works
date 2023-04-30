/*
одновременное написание потоков в одну переменную не гарантирует постоянство данных
так как каждый поток бореться за доступ к ядру (работает только у объектов)

join() --  ожидания потоков
synchronized --  синхранизирует потоки между собой
* */
package multiTrack;

public class Synchronized {
    private int counter;

    public static void main(String[] args) throws InterruptedException {
        Synchronized test = new Synchronized();
        test.doWork();

    }

    // при помощи synchronized синхранизируем потоки между собой в методе
    public synchronized void increment() {
        counter++;
    }

    public void doWork() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++)
                    increment();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++)
                    increment();
            }
        });
        thread1.start();
        thread2.start();

        thread1.join(); // ожидаем поток 1
        thread2.join(); // ожидаем поток 2

        System.out.println(counter);
    }
}

