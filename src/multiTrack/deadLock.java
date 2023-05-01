/*
когда оба потока забирают разные lock  то образуеться deadLock  так как оба
элимента забрав lock не могут передать его другому и программа будет выполняться бесконечно

чтобы не допустить этого:
    1) потоки должны брать одинаковые lock  элименты
    2)
 */
package multiTrack;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class deadLock {
    public static void main(String[] args) throws InterruptedException {
        Runner runner = new Runner();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                runner.firstThread();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                runner.secondThread();
            }
        });
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        runner.finishThread();
    }
}

class Runner{
    private Account account1 = new Account();
    private Account account2 = new Account();
    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    private void taskLocks(Lock lock1, Lock lock2){
        boolean firstLockTaken = false;
        boolean secondLockTaken = false;
        while (true){
            try {
                firstLockTaken = lock1.tryLock();
                secondLockTaken = lock2.tryLock();
            }finally {
                if (firstLockTaken && secondLockTaken) {
                    return;
                }

                if (firstLockTaken){
                    lock1.unlock();
                }
                if (secondLockTaken){
                    lock2.unlock();
                }
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }



    public void firstThread(){
        Random random = new Random();
        for (int i = 0; i <10000; i++){
            /*
                lock1.lock();
                // первый поток остановиться сдесь
                lock2.lock();
            */

            taskLocks(lock1, lock2);
            try {
                Account.transfer(account1,account2,random.nextInt(100));
            }finally {
                lock1.unlock();
                lock2.unlock();
            }

        }
    }

    public void secondThread(){
        Random random = new Random();
        for (int i = 0; i <10000; i++){
            /*
                lock2.lock();
                // второй поток остановиться сдесь
                lock1.lock();
            * */

            taskLocks(lock2,lock1);

            try {
                Account.transfer(account2,account1,random.nextInt(100));
            }finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void finishThread(){
        System.out.println(account1.getBalance());
        System.out.println(account2.getBalance());

        System.out.println("Total balance: " + (account1.getBalance() + account2.getBalance()));
    }
}

class Account {
    private int balance = 10000;
    public void deposit(int amount){
        balance += amount;
    }
    public void withDraw (int amount){
        balance -= amount;
    }

    public int getBalance(){
        return balance;
    }

    public static void transfer(Account acc1, Account acc2, int amount){
        acc1.withDraw(amount);
        acc2.deposit(amount);

    }
}