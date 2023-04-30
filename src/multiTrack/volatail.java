/*
    volatile -- ключевое слово когда одна переменная делиться на несколько потоков
(один поток пишет в эту переменную а другие читают из этой переменной)
* */
package multiTrack;

import java.util.Scanner;

public class volatail {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        myThread.shutdown();

    }
}

class MyThread extends Thread{

    private volatile boolean running = true; //  переменная которая по умолчанию запускает поток
    public void  run(){
        while (running){
            System.out.println("Hello");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    // метод для остановки потока
    public void shutdown(){
        this.running = false;
    }
}
