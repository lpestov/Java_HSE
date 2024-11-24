package lab4;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApiClient apiClient = new ApiClient();

        String usersUrl = "https://fake-json-api.mock.beeceptor.com/users";
        String postsUrl = "https://dummy-json.mock.beeceptor.com/posts";

        try {
            // Получение и вывод пользователей
            List<User> users = apiClient.getUsers(usersUrl);
            System.out.println("=== Список Пользователей ===");
            for (User user : users) {
                System.out.println(user);
            }

            // Получение и вывод постов
            List<Post> posts = apiClient.getPosts(postsUrl);
            System.out.println("\n=== Список Постов ===");
            for (Post post : posts) {
                System.out.println(post);
            }

        } catch (ApiException | JsonParsingException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}
