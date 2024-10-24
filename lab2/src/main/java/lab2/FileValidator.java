package lab2;

import java.io.File;
import java.io.IOException;

public class FileValidator {
    public static void validateInputFile(String fileName) throws CustomFileNotFoundException, CustomAccessDeniedException, CustomInvalidFileNameException {
        if (fileName == null || fileName.trim().isEmpty()) {
            throw new CustomInvalidFileNameException("Имя файла не может быть пустым.");
        }

        File file = new File(fileName);

        if (!file.exists()) {
            throw new CustomFileNotFoundException("Файл " + fileName + " не существует.");
        }

        if (!file.canRead()) {
            throw new CustomAccessDeniedException("Нет доступа для чтения файла " + fileName + ".");
        }

        if (file.isDirectory()) {
            throw new CustomInvalidFileNameException(fileName + " является директорией, а не файлом.");
        }
    }

    public static void validateOutputFile(String fileName) throws CustomAccessDeniedException, CustomInvalidFileNameException, IOException {
        if (fileName == null || fileName.trim().isEmpty()) {
            throw new CustomInvalidFileNameException("Имя выходного файла не может быть пустым.");
        }

        File file = new File(fileName);

        if (file.exists()) {
            if (!file.canWrite()) {
                throw new CustomAccessDeniedException("Нет доступа для записи в файл " + fileName + ".");
            }
        } else {
            File parent = file.getParentFile();
            if (parent != null && !parent.exists()) {
                throw new CustomInvalidFileNameException("Директория " + parent.getAbsolutePath() + " не существует.");
            }
            if (parent != null && !parent.canWrite()) {
                throw new CustomAccessDeniedException("Нет доступа для создания файла в директории " + parent.getAbsolutePath() + ".");
            }
            try {
                if (!file.createNewFile()) {
                    throw new IOException("Не удалось создать файл " + fileName + ".");
                }
            } catch (IOException e) {
                throw new IOException("Ошибка при создании файла " + fileName + ": " + e.getMessage());
            }
        }
    }
}
