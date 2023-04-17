
package collections.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class linkedHashMap_and_treeMap {
    public static void main(String[] args) {
        // не сохраняет порядок добавления
        Map <Integer, String>  hashMap= new HashMap<>();
        // сохраняет данные в порядке добавления
        Map <Integer, String> linkedHashMap = new LinkedHashMap<>();
        // сортируеться по ключу
        Map <Integer, String> treeMap = new TreeMap<>();

        testMap(hashMap);
        testMap(linkedHashMap);
        testMap(treeMap);
    }

    public static void testMap(Map <Integer, String> map){
        map.put(39, "bob");
        map.put(12, "mike");
        map.put(78, "tom");
        map.put(0, "tim");
        map.put(1580, "lewis");
        map.put(7, "bob");
        System.out.println(" ");
        for (Map.Entry<Integer,String> entry: map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
