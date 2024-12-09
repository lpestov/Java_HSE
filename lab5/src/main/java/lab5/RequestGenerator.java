package lab5;

import java.util.Random;

public class RequestGenerator implements Runnable {
    private ElevatorManager manager;
    private Random random;

    // Конструктор
    public RequestGenerator(ElevatorManager manager) {
        this.manager = manager;
        this.random = new Random();
    }

    // Реализует логику работы генератора запросов. Этот метод будет выполняться в отдельном потоке
    @Override
    public void run() {
        try {
            while (true) {
                int floor = random.nextInt(15) + 1; // Генерация этажей
                System.out.println("New request for floor: " + floor);
                manager.addRequest(floor);
                Thread.sleep(2000); // Генерация заявок каждые 2 секунды
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
