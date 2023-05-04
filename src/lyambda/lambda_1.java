package lyambda;
interface Executable { // создаем интерфейс
    int execute(int x, int y); // возвращаем то что указано в интерфейсе
}
class Runner{
    public void run(Executable e){
        int a = e.execute(10, 15);
        System.out.println(a);
    }
}
//class ExecutableImplementation implements Executable{ // 1 способ через класс
//    @Override
//    public void execute() {
//        System.out.println("Hello");
//    }
//}
public class lambda_1 {
    public static void main(String[] args) {
        Runner runner = new Runner();
//        runner.run(new ExecutableImplementation()); // 1 способ реализации интерфейса
        runner.run(new Executable() { // 2 способ реализации интерфейса
            @Override
            public int execute(int x, int y) {
                System.out.println("Hello");
                System.out.println("Goodbye"); // добавили строчку
                return x + y;
            }
        });
        final int a = 1; //  если мы планируем использовать наши данные в
        // лямбде из вне то эти данные должны быть статическими
        // и не изменяться и должны быть помечен как final


        runner.run((x, y) ->  {
            System.out.println("Hello");
            System.out.println("Goodbye"); // добавили строчку
            return x + y + a;
        });

    }

}
