package taskeight;

public class Person {

    private String name;
    private String surname;
    private String birthday;

    public Person(PersonBuilder personBuilder) {
        name = personBuilder.name;
        surname = personBuilder.surname;
        birthday = personBuilder.birthday;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getBirthday() {
        return birthday;
    }

    public static class PersonBuilder {

        private String name;
        private String surname;
        private String birthday;

        public PersonBuilder(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }

        public PersonBuilder getBirthday(String birthday) {
            this.birthday = birthday;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

}
