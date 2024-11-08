package lab3;

// Исключение, возникающее при некорректном вводе
public class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}
