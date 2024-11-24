package lab4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.util.List;


public class ApiClient {
    private final Gson gson;

    public ApiClient() {
        this.gson = new Gson();
    }

    public String get(String urlString) throws ApiException {
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        StringBuilder responseContent = new StringBuilder();

        try {
            URL url = new URL(urlString);
            // Открытие соединения и приведение к типу HttpURLConnection
            connection = (HttpURLConnection) url.openConnection();

            // Настройка запроса
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000); // 5 секунд
            connection.setReadTimeout(5000);    // 5 секунд

            int status = connection.getResponseCode();

            if (status != HttpURLConnection.HTTP_OK) {
                throw new ApiException("Не удалось получить данные. Код состояния HTTP: " + status);
            }

            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;

            while ((line = reader.readLine()) != null) {
                responseContent.append(line);
            }

        } catch (IOException e) {
            throw new ApiException("Ошибка при выполнении HTTP-запроса: " + e.getMessage(), e);
        } finally {
            // Закрытие ресурсов
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    // Исключение при закрытии (игнорим)
                }
            }
            if (connection != null) {
                connection.disconnect();
            }
        }

        return responseContent.toString();
    }


    // Получает список пользователей из указанного URL
    public List<User> getUsers(String url) throws ApiException, JsonParsingException {
        String jsonResponse = get(url);
        try {
            /* JSON -> List<User>
            // Используем TypeToken для получения типа List<User>, так как мы не можем получить тип во время итерации
            по jsonResponse
             */
            return gson.fromJson(jsonResponse, new TypeToken<List<User>>() {}.getType());
        } catch (JsonSyntaxException e) {
            throw new JsonParsingException("Не удалось разобрать JSON пользователей: " + e.getMessage(), e);
        }
    }

    // Получает список постов из указанного URL
    public List<Post> getPosts(String url) throws ApiException, JsonParsingException {
        String jsonResponse = get(url);
        try {
            // JSON -> List<Post>
            return gson.fromJson(jsonResponse, new TypeToken<List<Post>>() {}.getType());
        } catch (JsonSyntaxException e) {
            throw new JsonParsingException("Не удалось разобрать JSON постов: " + e.getMessage(), e);
        }
    }

}
