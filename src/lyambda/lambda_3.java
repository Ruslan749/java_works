/*
    stream() -- превращаем массив в поток
    map () -- берет каждый элемент из набора данных и сопоставляет ему элемент
сопоставление описывается в лямбде
    filter () -- фильтрация данных при помощи сравнивания данных с условием
и если выходит true то, записывает результат, если нет то игнорирует его
    forEach() -- итерируется по каждому элементу и возвращает его, с которым можно делать
все что угодно
    reduce() -- сжимает массив до одного элемент по условию или операциям

    toArray() -- превращаем поток обратно в простой массив;
    collect(Collectors.toList()) -- превращаем поток обратно в коллекцию элементов

* */
package lyambda;

import java.util.*;
import java.util.stream.Collectors;

public class lambda_3 {
    public static void main(String[] args) {
        int [] arr1 = new int[10];
        List<Integer> list1 = new ArrayList<>();

        fillArr(arr1);
        fillList(list1);

        System.out.println(Arrays.toString(arr1));
        System.out.println(list1);

//        ............. 1 способ ..........

/*        for (int i = 0; i < 10; i++){
            arr[i] = arr[i] * 2;
            list.set(i, list.get(i) * 2);
        }*/

//        ............. 2 способ ..........
                    // map метод
        arr1 = Arrays.stream(arr1)
                .map(a -> a * 2)
                .toArray();

        arr1 = Arrays.stream(arr1)
                .map( a -> 3)
                .toArray();
        arr1 = Arrays.stream(arr1)
                .map( a -> a + 1)
                .toArray();

       list1 =  list1.stream()
                .map(a -> a * 2)
               .collect(Collectors.toList());

        System.out.println(Arrays.toString(arr1));
        System.out.println(list1);

                        // filter
        int[] arr2 = new int[10];
        List<Integer> list2 = new ArrayList<>();

        fillArr(arr2);
        fillList(list2);

        arr2 = Arrays.stream(arr2)
                .filter(a -> a % 2 == 0)
                .toArray();

        list2 = list2.stream()
                .filter(a -> a % 2 == 0)
                .collect(Collectors.toList());


        System.out.println(Arrays.toString(arr2));
        System.out.println(list2);

                        //        forEach
        Arrays.stream(arr2).forEach(System.out::println); // сокращенная запись
        list2.stream().forEach(a -> System.out.println(a));

                            // reduce

       int[] arr3 = new int[10];
       List<Integer> list3 = new ArrayList<>();

        fillArr(arr3);
        fillList(list3);
        /*
        Пример работы: без заданного acc
            Дан массив: [1, 2, 3]

            1 итерация:
                acc = 1 -- первое значение
                b = 2 -- следующее значение от начального
                acc + b = 3 -- выполнение операции
                acc = 3 -- присваивается результат вычисления
            2 итерация:
                acc = 3 -- результат предыдущей итерации
                b = 3 -- следующее значение от предыдущей итерации
                acc + b = 6 -- выполнение операции
                acc = 6 -- присваивается результат вычисления
             3 итерация:
                acc = 6 -- результат предыдущей итерации
                b = - -- отсутствует следующее значение операции не будет
                acc = 6 -- возвращается результат предыдущей итерации

        Пример работы: c заданным acc
            Дан массив: [1, 2, 3]
            Заданное значение: 0

            1 итерация:
                acc = 0 -- заданное значение
                b = 1 -- начальное значение
                acc + b = 1 -- выполнение операции
                acc = 1 -- присваивается результат вычисления
            2 итерация:
                acc = 1 -- результат предыдущей итерации
                b = 2 -- следующее значение от предыдущей итерации
                acc + b = 3 -- выполнение операции
                acc = 3 -- присваивается результат вычисления
            3 итерация:
                acc = 3 -- результат предыдущей итерации
                b = 3 -- следующее значение от предыдущей итерации
                acc + b = 6 -- выполнение операции
                acc = 6 -- присваивается результат вычисления
             4 итерация:
                acc = 6 -- результат предыдущей итерации
                b = - -- отсутствует следующее значение операции не будет
                acc = 6 -- возвращается результат предыдущей итерации
        * */

        int sum1 = Arrays.stream(arr3).reduce(0,(acc, b) -> acc + b); //  c заданным acc
        int sum2 = list3.stream().reduce((acc, b) -> acc * b).get(); // без заданного acc

        System.out.println(sum1);
        System.out.println(sum2);

                            // Пример с несколькими операциями
        int[] arr4 = new int[10];
        fillArr(arr4);

        arr4 = Arrays.stream(arr4)
                .filter(a -> a % 2 != 0)
                .map(a -> a * 2)
                .toArray();

        System.out.println(Arrays.toString(arr4));

        // Пример с другими коллекциями

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(5);

        System.out.println(set);

        set = set.stream().map(a -> a * 3).collect(Collectors.toSet());

        System.out.println(set);
    }



    private static void fillList(List<Integer> list) {
        for (int i = 0; i < 10; i++){
            list.add(i + 1);
        }
    }

    private static void fillArr(int[] arr) {
        for (int i = 0; i < 10; i++){
            arr[i] = i+1;
        }
    }
}
