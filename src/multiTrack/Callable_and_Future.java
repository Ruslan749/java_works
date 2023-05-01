/*
Future -- интерфейс который ожидает на выходе результат действия потока
new Callable -- метод который принимает и возвращает значения
* */
package multiTrack;

import java.util.Random;
import java.util.concurrent.*;

public class Callable_and_Future {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<Integer> future = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("Starting");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Finished");
                Random random = new Random();

                int RandomValue = random.nextInt();
                if (RandomValue < 5){
                    throw new Exception("что то плохое");
                }
                return random.nextInt(10);
            }
        });

        executorService.shutdown();

        try {
            int result = future.get(); // дожидаеться оканчания выполнения потока
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            Throwable ex = e.getCause(); // получаем само исключение
            System.out.println(ex.getMessage()); // получаем текст нашего исключения
        }

    }
}
