/*
 патерн producer_consumer на более низком уровне
* */
package multiTrack;

import java.util.Scanner;

public class Metods_wait_and_notify {
    public static void main(String[] args) throws InterruptedException {
        WaitAndNotify wn = new WaitAndNotify();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wn.producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wn.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}

class WaitAndNotify{
    public void producer() throws InterruptedException {
        synchronized (this){
            System.out.println("Producer thread started... ");
            wait(); // вызываеться только на синхранизованом блоке
            // 1) отдаем lock другим потокам
            // 2) ждем пока не будет вызван notify  на этом же объекте
            System.out.println("Producer thread resumed... ");
        }
    }
    public void consumer() throws InterruptedException{
            Thread.sleep(2000);
        Scanner scanner = new Scanner(System.in);

        synchronized (this){
            System.out.println("Waiting for return key pressed");
            scanner.nextLine();
            notify();
        }
    }
}
