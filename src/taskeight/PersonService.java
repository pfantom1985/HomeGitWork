package taskeight;

public class PersonService {

    private final String name;
    private final String surname;
    private final String birthday;

    public PersonService(PersonBuilder personBuilder) {
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

    public static PersonBuilder builder() {
        return new PersonBuilder();
    }

    public static class PersonBuilder {

        private String name;
        private String surname;
        private String birthday;

        public PersonBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PersonBuilder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public PersonBuilder birthday(String birthday) {
            this.birthday = birthday;
            return this;
        }

        public PersonService build() {
            return new PersonService(this);
        }
    }

}
