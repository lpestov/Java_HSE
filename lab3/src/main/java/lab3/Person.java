package lab3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class Person {
    private String fullName;
    private LocalDate birthDate;

    // Конструктор
    public Person(String fullName, String birthDate) throws InvalidInputException {
        // Удаляем лишние пробелы
        fullName = fullName.trim().replaceAll("\\s+", " ");

        // Проверяем корректность ввода
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new InvalidInputException("Поле 'ФИО' не должно быть пустым.");
        }
        if (!fullName.matches("([\\p{IsCyrillic}]+\\s){2}[\\p{IsCyrillic}]+")) {
            throw new InvalidInputException("Неверный формат ФИО. Введите в формате 'Фамилия Имя Отчество'.");
        }
        this.fullName = fullName;

        // Проверка, что birthDate не пустая и соответствует формату
        if (birthDate == null || birthDate.trim().isEmpty()) {
            throw new InvalidInputException("Поле 'Дата рождения' не должно быть пустым.");
        }
        /*
        Проверка, что дата соответствует формату и преобразование в LocalDate из String
        withLocale преобразует дату в зависимости формата системы
         */
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy").withLocale(Locale.getDefault());
        try {
            this.birthDate = LocalDate.parse(birthDate, formatter);
        } catch (DateTimeParseException e) {
            throw new InvalidInputException("Неверный формат даты. Введите в формате 'дд.мм.гггг'.");
        }

    }

    // Геттеры
    public String getFullName() {
        return fullName;
    }

    public String getPatronymic() {
        return fullName.split(" ")[2];
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

}
