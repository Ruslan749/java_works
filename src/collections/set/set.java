/*
set - не имеет дубликатов в колекции
addAll -- соединяет две колекции и объединяет их в одну бе повторений
retailAll -- оставляеться только те элименты которые повторяються
removeAll -- остаються только те элименты которые не повторяються

 */
package collections.set;

import java.util.*;

public class set {
    public static void main(String[] args) {
        // не сохраняет порядок добавления
        Set<String> hashSet = new HashSet<>();
        // сохраняет данные в порядке добавления
        Set<String> linkedHashSet = new LinkedHashSet<>();
        // сортируеться по значению
        Set<String> treeSet = new TreeSet<>();

        // добавление элиментов в коллекцию
        addSet(hashSet);
        addSet(linkedHashSet);
        addSet(treeSet);

        // проверка есть ли такое значение в колекции
        System.out.println(hashSet.contains("Tom"));
        System.out.println(hashSet.contains("Tim"));
        System.out.println(" ");
        // проверка на пустату колекции
        System.out.println(hashSet.isEmpty());
    }

    public static void addSet(Set<String> setList) {
        System.out.println(" ");

        setList.add("Mike");
        setList.add("Katy");
        setList.add("Tom");
        setList.add("Georg");
        setList.add("Donald");

        for (String name : setList) {
            System.out.println(name);
        }

        System.out.println(" ");
    }

}
