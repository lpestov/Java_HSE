package lab2;

// Исключение когда файл не найден
class CustomFileNotFoundException extends Exception {
    public CustomFileNotFoundException(String message) {
        super(message);
    }
}


// Исключение при отказе в доступе к файлу
class CustomAccessDeniedException extends Exception {
    public CustomAccessDeniedException(String message) {
        super(message);
    }
}

// Исключение при неверном имени файла
class CustomInvalidFileNameException extends Exception {
    public CustomInvalidFileNameException(String message) {
        super(message);
    }
}