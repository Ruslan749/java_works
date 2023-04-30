/*
start() --  создает поток и запускает его из метода run()
Sleep() --  поток останавливаеться на заданное время ( обрабатываеться через исключение InterruptedException )
*/
package multiTrack;

public class intro_multiThread {
    public static void main(String[] args) throws InterruptedException {
        // первый поток ( первый способ создания потока)
        MyThread myThread = new MyThread();
        myThread.start(); // запускаем поток
        // второй поток ( второй способ создания потока)
        Thread thread = new Thread(new Runner());
        thread.start();

        System.out.println("Hello from main Thread");
    }
    // первый способ создания потока
    static class MyThread extends Thread{
        // переопределяем метод run()  в котором будет выполняться код написанный нами
        public void run(){
            for (int i = 0; i<1000; i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Hello from myThread" + i);
            }
        }
    }

    // второй способ создания потока
    static class Runner implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i<1000; i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Hello from myThread" + i);
            }
        }
    }
}
