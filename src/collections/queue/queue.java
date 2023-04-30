/*
        ОЧЕРЕДЬ
    первый пришол последний вышел

    -------- выбрасывает исключение------
add -- добавление элиментов в очередь
remove -- доставание первого элимента из очереди
element -- посмотреть первый элимент в очереди без удаления

    -------- выбрасывает boolean  значение без исключения------
offer -- добавление элиментов в очередь
pull -- доставание первого элимента из очереди
peek -- посмотреть первый элимент в очереди без удаления
 */
package collections.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class queue {
    public static void main(String[] args) {
        Person person1 = new Person(1);
        Person person2 = new Person(2);
        Person person3 = new Person(3);
        Person person4 = new Person(4);

        // обязаны указать число(максимальное количество очереди)
        Queue<Person> people = new ArrayBlockingQueue<Person>(10);
        people.add(person3);
        people.add(person2);
        people.add(person4);
        people.add(person1);

        System.out.println(people.remove());
        System.out.println(people.element());
        System.out.println(people);

    }
}
class Person {
    private int id;

    public Person(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                '}';
    }
}
