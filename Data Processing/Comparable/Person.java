public class Person implements Comparable<Person> {
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Implement the compareTo method to compare by age
    @Override
    public int compareTo(Person other) {
        return Integer.compare(this.age, other.age);
        // Alternatively: return this.age - other.age;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}
