package taskeight;

/*
Задание 69. Создайте класс Person с полями: имя, фамилия, год рождения. Реализуйте у этого класса паттерн Строитель.
            Введите поля с клавиатуры и заполните объект класса Person с помощью паттерна Стромтель.
*/

import java.util.Scanner;

class MainPerson {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        String nameScanner = scanner.nextLine();
        System.out.println("You entered the name: " + nameScanner);

        System.out.print("Enter surname: ");
        String surnameScanner = scanner.nextLine();
        System.out.println("You entered the surname: " + surnameScanner);

        System.out.print("Enter bithday: ");
        String bithdayScanner = scanner.nextLine();
        System.out.println("You entered the bithday: " + bithdayScanner);

        Person person = new Person.PersonBuilder(nameScanner, surnameScanner).getBirthday(bithdayScanner).build();
        System.out.println("\nResult of builder using: " + person.getName() + " " + person.getSurname() + " " + person.getBirthday());

    }

}
