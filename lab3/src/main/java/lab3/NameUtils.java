package lab3;

public class NameUtils {
    public static String getInitials(String fullName) {
        String[] parts = fullName.split(" ");
        // Возвращает инициалы в формате "Фамилия И. О."
        return String.format("%s %c.%c.", parts[0].substring(0, 1).toUpperCase() + parts[0].substring(1), Character.toUpperCase(parts[1].charAt(0)), Character.toUpperCase(parts[2].charAt(0)));
    }

    // Определяем пол по отчеству
    public static String getGender(String patronymic) {
        if (patronymic.endsWith("вич") || patronymic.endsWith("ьич") || patronymic.endsWith("тич") || patronymic.endsWith("глы")) {
            return "Мужской";
        } else if (patronymic.endsWith("вна") || patronymic.endsWith("чна") || patronymic.endsWith("шна") || patronymic.endsWith("ызы")) {
            return "Женский";
        } else {
            return "Определить не удалось";
        }
    }
}
