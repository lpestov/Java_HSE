package lab5;

// Исключение для проверки на правильность этажа
public class InvalidFloorException extends Exception {
    public InvalidFloorException(String message) {
        super(message);
    }
}

