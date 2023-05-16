package reflection;
@Author(name = "Ruslan", dateCreation = 2023)
public class Person {
    private int id;
    private String name;
    public Person() {
        this.id = -1;
        this.name = "No name";
    }
    public void sayHello(){
        System.out.println(" Person id: " + id + " and name: " + name);
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
