/*
add() -- Добавление элиментов в колекциюж
get() -- Получение элиментов из колекции
size() -- получение размера arrayList
remove() -- Удаление элиментов из массива
 */
package collections.list;

import java.util.ArrayList;
import java.util.List;

public class list {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i <= 10; i++){
            arrayList.add(i);
        }
        System.out.print(arrayList);

        System.out.println(" \n полученые элименты из массива : ");
        System.out.println(arrayList.get(0));
        System.out.println(arrayList.get(10));

        System.out.println("полученые размера массива : ");
        System.out.println(arrayList.size());

        // вывод элиментов из массива
        System.out.println("перебор элиментов: ");
        for (int x: arrayList) {
            System.out.print(x);
        }
        System.out.println(" ");
        for (int i = 0; i < arrayList.size(); i++){
            System.out.print(arrayList.get(i));
        }
        System.out.println(" ");

        // удаление элиментов
        System.out.println("удаление элимента 5 из массива : ");
        arrayList.remove(5);
        System.out.println(arrayList);
        System.out.println("нынешний размер массива: " + arrayList.size());


    }
}
