package multiTrack;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
    public static void main(String[] args) throws InterruptedException {
        // создаем пул потоков
        ExecutorService executorService = Executors.newFixedThreadPool(2); // это количество потоков которое нужно создать
        for (int i = 0; i < 5; i++){
            // передали 5 заданий класса Work
            executorService.submit(new Work(i));
        }
        //  прекращаем выполнения задания чтоб выполнялись те чо мы передали
        executorService.shutdown();
        System.out.println("All task submitted");

        // ожидание окончание (сколько мы хотим ждать пока все потоки выполнят свое задание)
        // если задание выполнено за заданый промежуток то все хорошо если нет, то выкинем исключение и завершим программу
        executorService.awaitTermination(1, TimeUnit.DAYS);
    }
}
class Work implements Runnable{
    private int id;

    public Work(int id) {
        this.id = id;
    }

    public void run(){
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Work " + id + ": " + "all completed");
    }
}
