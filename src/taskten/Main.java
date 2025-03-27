package taskten;

// Задание 76. Напишите программу, которая будет разбирать json файл "tester".

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.io.File;

public class Main {
    public static void main(String[] args) throws IOException {

        String fileName = "tester.json";
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Person personTwo = objectMapper.readValue(new File(fileName), Person.class);
            System.out.println("Id: " + personTwo.getId() + ",");
            System.out.println("Name: " + personTwo.getName() + ",");
            System.out.println("Permanent: " + personTwo.isPermanent() + ",");
            System.out.print("Address: " + personTwo.getAddress().getStreet() + ", ");
            System.out.print(personTwo.getAddress().getCity() + ", ");
            System.out.print(personTwo.getAddress().getZipcode() + ",\n");
            System.out.print("Phone: ");
            for (int phoneNumber : personTwo.getPhoneNumber()) {
                System.out.print(phoneNumber + ", ");
            }
            System.out.println("\nRole: " + personTwo.getRole() + ",");
            System.out.print("Cities: ");
            for (String cities : personTwo.getCities()) {
                System.out.print(cities + ", ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

