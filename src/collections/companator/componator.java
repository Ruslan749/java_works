package collections.companator;


import java.util.*;

// Когда не устраивает естественный порядок сортировки сщздаем свой  comparator
class StringLengthComporator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        if (o1.length() > o2.length()){
            return 1;
        }else if (o1.length() < o2.length()){
            return -1;
        }else {
            return 0;
        }
    }
}
public class componator {
    public static void main(String[] args) {
        List <String> animals = new ArrayList<>();
        animals.add("dog");
        animals.add("cat");
        animals.add("aa");
        animals.add("frog");
        animals.add("abcd");
        animals.add("bird");
        animals.add("c");


        Collections.sort(animals, new StringLengthComporator()); // сортировка в естественном порядке
        System.out.println(animals);

        List <Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(0);
        numbers.add(500);
        numbers.add(55);
// второй способ добавления comorator
        Collections.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2){
                    return 1;
                }else if (o1 < o2){
                    return -1;
                }else {
                    return 0;
                }
            }
        }); // сортировка в естественном порядке
        System.out.println(numbers);

        // создадим объект

        List<Person> people = new ArrayList<>();
        people.add(new Person(1,"Bob"));
        people.add(new Person(3,"Mike"));
        people.add(new Person(2,"Katy"));


        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.getId() > o2.getId()){
                    return 1;
                }else if (o1.getId() < o2.getId()){
                    return -1;
                }else {
                    return 0;
                }
            }
        });

        System.out.println(people);
    }
}
class Person{
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
