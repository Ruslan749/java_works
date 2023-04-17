package collections.comparable;

import java.util.*;

public class comparable {
    public static void main(String[] args) {
        List <People> peapleList = new ArrayList<>();
        Set <People> peapleSet = new TreeSet<>();


        addElements(peapleList);
        addElements(peapleSet);

        Collections.sort(peapleList);

        System.out.println(peapleList);
        System.out.println(peapleSet);

    }
    private static void addElements(Collection collection){
        collection.add(new People(4,"George"));
        collection.add(new People(2,"Tom"));
        collection.add(new People(3,"Katy"));
        collection.add(new People(1,"Bob"));
    }

}

class People implements Comparable<People> {
    private int id;
    private String name;

    public People(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        People persons = (People) o;

        if (id != persons.id) return false;
        return Objects.equals(name, persons.name);
    }

    public int getId() {
        return id;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(People o) {
        if (this.id > o.getId()){
            return 1;
        }else if (this.id < o.getId()){
            return -1;
        }else {
            return 0;
        }
    }
}