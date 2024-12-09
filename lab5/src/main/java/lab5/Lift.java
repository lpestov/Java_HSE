package lab5;

import java.util.ArrayList;
import java.util.List;

public class Lift implements Runnable {
    private int id;
    private int currentFloor;
    private boolean isMoving;
    private List<Integer> requests;
    private final Object lock = new Object();

    // Конструктор
    public Lift(int id) {
        this.id = id;
        this.currentFloor = 0;
        this.requests = new ArrayList<>();
        this.isMoving = false;
    }

    // Добавление запроса
    public synchronized void addRequest(int floor) throws InvalidFloorException {
        if (floor < 1 || floor > 15) { // Проверка на допустимый диапазон этажей
            throw new InvalidFloorException("Invalid floor: " + floor + ". Floor must be between 1 and 15.");
        }
        synchronized (lock) {
            if (floor != currentFloor && !requests.contains(floor)) { // Проверяем, что лифт не находится на этом этаже
                requests.add(floor);
            } else if (floor == currentFloor) {
                System.out.println("Request ignored: Lift " + id + " is already on floor " + floor);
            }
        }
    }

    // Геттеры
    public int getCurrentFloor() {
        return currentFloor;
    }

    // Проверка на наличие запросов
    public boolean isIdle() {
        synchronized (lock) {
            return requests.isEmpty();
        }
    }

    // Проверка и обработка заявок
    @Override
    public void run() {
        try {
            while (true) {
                processRequests();
                Thread.sleep(100); // Ожидание для проверки новых запросов
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // Обработка запросов
    private void processRequests() {
        while (!requests.isEmpty()) {
            int nextFloor;
            synchronized (lock) {
                nextFloor = requests.remove(0);
            }
            moveToFloor(nextFloor);
        }
    }

    // Перемещение на этаж
    private void moveToFloor(int floor) {
        if (floor == currentFloor) {
            System.out.println("Lift " + id + " is already on floor " + floor + ". Skipping movement.");
            return; // Не выполняем перемещение если был запрос на текущий этаж
        }

        isMoving = true;
        System.out.println("Lift " + id + " moving from floor " + currentFloor + " to floor " + floor);
        try {
            Thread.sleep(Math.abs(currentFloor - floor) * 500); // Задержка движения
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        currentFloor = floor;
        isMoving = false;
        System.out.println("Lift " + id + " arrived at floor " + floor);
    }

    public String getId() {
        return String.valueOf(id);
    }
}
