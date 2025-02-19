package taskeight;

/*
Задание 69. Создайте класс Person с полями: имя, фамилия, год рождения. Реализуйте у этого класса паттерн Строитель.
            Введите поля с клавиатуры и заполните объект класса Person с помощью паттерна Стромтель.
*/

import java.util.Scanner;

class MainApplicationControl {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        String userEnteredName = scanner.nextLine();
        System.out.println("You entered the name: " + userEnteredName);

        System.out.print("Enter surname: ");
        String userEnteredSurname = scanner.nextLine();
        System.out.println("You entered the surname: " + userEnteredSurname);

        System.out.print("Enter bithday: ");
        String userEnteredBithday = scanner.nextLine();
        System.out.println("You entered the bithday: " + userEnteredBithday);

        PersonService person = PersonService.builder().name(userEnteredName).surname(userEnteredSurname).birthday(userEnteredBithday).build();
        System.out.println("\nResult of builder using: " + person.getName() + " " + person.getSurname() + " " + person.getBirthday());

    }

}
