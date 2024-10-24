package lab2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteToFile {

    public static void writeFrequencyDictionary(String fileName, Map<Character, Integer> freqMap) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Частотный словарь букв английского алфавита:\n");
            for (Character key : freqMap.keySet()) {
                writer.write(key + ": " + freqMap.get(key) + "\n");
            }
        } catch (IOException e) {
            throw new IOException("Ошибка при записи в файл " + fileName + ": " + e.getMessage());
        }
    }
}
