### **Менеджер управления лифтами**

Эта работа симулирует многопоточную систему управления лифтами в многоквартирном доме. Проект включает генератор заявок, менеджер для распределения задач между лифтами и реализацию двух независимых лифтов.

---

### **Функционал**
1. **Менеджер лифтов**:
    - Оптимизирует выбор лифта для обработки заявки.
    - Учитывает расстояние до целевого этажа и занятость лифта.

2. **Лифты**:
    - Работают в отдельных потоках, обрабатывая очереди заявок.
    - Логируют свои действия: движение между этажами и выполнение запросов.

3. **Генератор заявок**:
    - Создает случайные запросы на вызов лифтов через регулярные интервалы.
    - Передает запросы менеджеру.

4. **Многопоточность**:
    - Генерация заявок и работа каждого лифта выполняются параллельно.

---

### **Технологии**
- Java (многопоточность через `Thread` и `Runnable`)
- Обработка исключений (`try-catch`)

---

### **Пример работы**
В консоль будут выводиться логи о создании заявок, выборе лифта и его движении. Пример вывода:

```
...
New request for floor: 2
Finding best lift for floor 2
Lift 1 is on floor 4, distance to floor 2: 2, is idle: true
Lift 2 is on floor 13, distance to floor 2: 11, is idle: false
Best lift for floor 2 is Lift 1
Lift 1 arrived at floor 1
Lift 1 moving from floor 1 to floor 2
Lift 1 arrived at floor 2
Lift 2 arrived at floor 3
Lift 2 moving from floor 3 to floor 5
New request for floor: 12
Finding best lift for floor 12
Lift 1 is on floor 2, distance to floor 12: 10, is idle: true
Lift 2 is on floor 3, distance to floor 12: 9, is idle: true
Best lift for floor 12 is Lift 2
...
```

---

### **Структура проекта**
```bash
java_hse
├── pom.xml                 # Главный POM-файл Maven
├── lab5                    # Модуль lab5
│   ├── pom.xml             # POM-файл модуля lab5
│   └── src
│   │   ├── main
│   │   │   ├── java
│   │   │   │   └── lab5
│   │   │   │   ├── Main.java                    # Главный класс приложения
│   │   │   │   ├── Lift.java                    # Класс лифта
│   │   │   │   ├── ElevatorManager.java         # Класс для управления лифтами
│   │   │   │   ├── RequestGenerator.java        # Генератор заявок
│   │   │   │   └── InvalidFloorException.java   # Исключение для недопустимого этажа
└── README.md                                    # Документация проекта
```

