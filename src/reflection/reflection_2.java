package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class reflection_2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Scanner scanner = new Scanner(System.in);

        // название класса 1, название класса 2, название метода
        Class classObject1 =  Class.forName(scanner.next()); // принимает на вход название класса
        Class classObject2 =  Class.forName(scanner.next());
        String methodName = scanner.next();

        // создаем метод и передаем туда (имя метода, типы данных которые принимает метод)
        Method n = classObject1.getMethod(methodName, classObject2);

        // создаем объекты наших классов
            // пустой конструктор
        Object o1 = classObject1.newInstance();
            // конструктор, который принимает на вход строковое значение
        Object o2 = classObject2.getConstructor(String.class).newInstance("String value");

        // Вызов объекта о1 с аргументом о2
        n.invoke(o1,o2);
        System.out.println(o1);

/*      reflection.Person java.lang.String setName

           1) ввели название объекта o1
           2) ввели название второго объекта
           3) передали в первый объект второй объект и передали это
        в метод setName первого объекта*/
    }

}
