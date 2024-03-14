public class Person {
    private final String name;
    private final String surname;
    private  String email;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public Person(String name, String surname, String email){
        this.name = name;
        this.surname = surname;
        this.email = email;

    }
}
