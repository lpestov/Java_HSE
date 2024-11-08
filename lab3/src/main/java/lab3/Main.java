package lab3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Введите ФИО: (Через пробел)");
            String fullName = scanner.nextLine();

            System.out.println("Введите дату рождения (дд.мм.гггг):");
            String birthDate = scanner.nextLine();

            Person person = new Person(fullName, birthDate);
            System.out.println("Инициалы: " + NameUtils.getInitials(person.getFullName()));
            System.out.println("Пол: " + NameUtils.getGender(person.getPatronymic()));
            System.out.println("Возраст: " + AgeUtils.getAge(person.getBirthDate()));
        } catch (InvalidInputException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
