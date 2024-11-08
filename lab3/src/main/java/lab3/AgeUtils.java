package lab3;

import java.time.LocalDate;
import java.time.Period;

public class AgeUtils {
    // в LocalDate по умолчанию используется формат даты yyyy-MM-dd
    public static String getAge(LocalDate birthDate) {
        // возвращает верное значение возраста в годах (с учетом текущего месяца)
        int age = Period.between(birthDate, LocalDate.now()).getYears();
        String ending = getAgeEnding(age);
        return age + " " + ending;
    }

    // возвращает окончание для слова "год" в зависимости от возраста
    private static String getAgeEnding(int age) {
        int lastDigit = age % 10;
        int lastTwoDigits = age % 100;

        // используя здравый смысл:
        if (lastTwoDigits >= 11 && lastTwoDigits <= 14) {
            return "лет";
        }

        return switch (lastDigit) {
            case 1 -> "год";
            case 2, 3, 4 -> "года";
            default -> "лет";
        };
    }
}
