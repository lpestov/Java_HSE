package lab2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Получим имя входного файла
            System.out.print("Введите имя входного TXT файла: ");
            String inputFileName = scanner.nextLine();

            // Чтение файла из ресурсов
            InputStream inputFileStream = Main.class.getClassLoader().getResourceAsStream(inputFileName);
            if (inputFileStream == null) {
                throw new CustomFileNotFoundException("Файл " + inputFileName + " не найден по каталогу resources.");
            }

            // Создадим частотный словарь
            FrequencyDictionary freqDict = new FrequencyDictionary(inputFileStream);
            Map<Character, Integer> frequencyMap = freqDict.generateFrequencyDictionary();

            // Запросим имя выходного файла
            System.out.print("Введите имя выходного TXT файла: ");
            String outputFileName = scanner.nextLine();

            // Проверим выходной файл
            FileValidator.validateOutputFile(outputFileName);

            // Сделаем запись в файл
            WriteToFile.writeFrequencyDictionary(outputFileName, frequencyMap);

            System.out.println("Частотный словарь успешно создан в файле " + outputFileName);
        } catch (CustomFileNotFoundException e) {
            System.err.println("Ошибка: Входной файл не найден.");
        } catch (CustomAccessDeniedException e) {
            System.err.println("Ошибка: Отказано в доступе к файлу.");
        } catch (CustomInvalidFileNameException e) {
            System.err.println("Ошибка: Неверное имя файла.");
        } catch (IOException e) {
            System.err.println("Ошибка ввода/вывода: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Произошла непредвиденная ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
