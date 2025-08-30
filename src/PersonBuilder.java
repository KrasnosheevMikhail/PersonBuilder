import java.util.OptionalInt;

public class PersonBuilder {
    protected String name;
    protected String surname;
    protected String city;
    protected int age;

    OptionalInt OptAge = OptionalInt.of(age);

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public OptionalInt getAge() {
        return OptAge;
    }

    public PersonBuilder setAge(int age) throws IllegalArgumentException {
        if (age < 0) throw new IllegalArgumentException("Возраст не может быть отрицательным!");
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.city = address;
        return this;
    }

    public Person build() throws IllegalArgumentException {
        Person person;
        if (name == null || surname == null)
            throw new IllegalArgumentException("Не все данные указаны");
        if (age < 0) {
            person = new Person(name, surname);
        } else person = new Person(name, surname, age);
        person.setAddress(city);
        return person;
    }
}