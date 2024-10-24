package lab2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class FrequencyDictionary {
    private InputStream inputStream;

    public FrequencyDictionary(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public Map<Character, Integer> generateFrequencyDictionary() throws IOException {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char c = 'A'; c <= 'Z'; c++) {
            frequencyMap.put(c, 0);
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            int c;
            while ((c = reader.read()) != -1) {
                char character = Character.toUpperCase((char) c);
                if (frequencyMap.containsKey(character)) {
                    frequencyMap.put(character, frequencyMap.get(character) + 1);
                }
            }
        }

        return frequencyMap;
    }
}
