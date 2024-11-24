# Взаимодействие с внешними API (Beeceptor) и обработка полученных данных


В модуле `lab4` происходит парсинг данных со следующих URL:

- **Пользователи (Users):**

  ```java
  String usersUrl = "https://fake-json-api.mock.beeceptor.com/users";
  ```

- **Посты (Posts):**

  ```java
  String postsUrl = "https://dummy-json.mock.beeceptor.com/posts";
  ```

#### Структура Вывода

После успешного выполнения программы, данные отображаются в консоли в следующем формате:

- **Список Пользователей:**

  ```
    === Список Пользователей ===
    User ID: 1
    Name: Jayne Langworth
    Company: O&#x27;Kon - Doyle
    Username: Torey29
    Email: Braeden_Stokes58@hotmail.com
    Address: 27068 Dolly Stravenue
    ZIP: 49418
    State: Maryland
    Country: Mexico
    Phone: 1-945-714-5000 x137
    Photo: https://json-server.dev/ai-profiles/39.png
    
    User ID: 2
    Name: Wyman Faker Attribute Error: person.astName is not supported
    Company: Heaney, Balistreri and Christiansen
    Username: Dandre23
    Email: Cade_Hodkiewicz@yahoo.com
    Address: 3020 Witting Throughway
    ZIP: 98394
    State: Rhode Island
    Country: Saint Kitts and Nevis
    Phone: 815-835-0046 x0811
    Photo: https://json-server.dev/ai-profiles/65.png

  // ... другие пользователи
  ```

- **Список Постов:**

  ```
    === Список Постов ===
    Post ID: 1
    User ID: 1
    Title: Introduction to Artificial Intelligence
    Body: Learn the basics of Artificial Intelligence and its applications in various industries.
    Link: https://example.com/article1
    Comment Count: 8
    
    Post ID: 2
    User ID: 2
    Title: Web Development with React
    Body: Build modern web applications using React.js and explore its powerful features.
    Link: https://example.com/article2
    Comment Count: 12

  // ... другие посты
  ```

## Структура проекта
```bash
java_hse
├── pom.xml                 # Главный POM-файл Maven
├── lab4                    # Модуль lab4
│   ├── pom.xml             # POM-файл модуля lab4
│   └── src
│       ├── main
│       │   ├── java
│       │   │   └── lab4
│       │   │       ├── Main.java                    # Главный класс приложения
│       │   │       ├── ApiClient.java               # Класс для выполнения HTTP-запросов
│       │   │       ├── User.java                    # Класс для представления пользователя
│       │   │       ├── Post.java                    # Класс для представления поста
│       │   │       ├── JsonParsingException.java    # Класс для обработки ошибок при парсинге JSON
│       │   │       └── ApiException.java            # Класс для обработки API-ошибок





