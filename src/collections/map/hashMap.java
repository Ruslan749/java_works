/*
!!! не сохраняет порядок добавления элиментов
put() -- добавить значения в карту
get () -- получить значение по ключу
 */
package collections.map;

import java.util.HashMap;
import java.util.Map;

public class hashMap {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("кошка", "cat");
        map.put("собака", "dog");
        map.put("слон", "elephant");

        System.out.println(map);
        System.out.println(map.get(1));

        for (Map.Entry<String,String> entry: map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
