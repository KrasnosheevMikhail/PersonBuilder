import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected String city;
    protected OptionalInt age;


    public Person(String name, String surname, OptionalInt age, String city) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.city = city;
    }


    public Person(String name, String surname) {
        this(name, surname, OptionalInt.empty(), null);
    }


    public Person(String name, String surname, int age) {
        this(name, surname, OptionalInt.of(age), null);
    }

    public boolean hasAge() {

        return age.isPresent();
    }

    public boolean hasAddress() {
        return city != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return age;
    }

    public String getAddress() {
        return city;
    }

    public void setAddress(String address) {
        this.city = address;
    }

    public void happyBirthday() {
        if (hasAge()) {
            age = OptionalInt.of(age.getAsInt() + 1);
        }
    }


    @Override
    public String toString() {
        return "Person  " + "name: " + name + "\n" + "surname: " + surname + "\n" +
                "age: " + age + "\n" + "adress: " + city + "\n";

    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(surname)
                .setAge(age.getAsInt())
                .setAddress(city);


    }

}