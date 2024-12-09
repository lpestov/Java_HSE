package lab5;

import java.util.List;

public class ElevatorManager {
    private List<Lift> lifts;

    // Конструктор
    public ElevatorManager(List<Lift> lifts) {
        this.lifts = lifts;
    }

    // Добавление запроса
    public void addRequest(int floor) {
        try {
            Lift bestLift = findBestLift(floor);
            bestLift.addRequest(floor);
        } catch (InvalidFloorException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Алгоритм поиска наилучшего лифта
    private Lift findBestLift(int floor) {
        Lift bestLift = null;
        int minDistance = Integer.MAX_VALUE;

        System.out.println("Finding best lift for floor " + floor);

        for (Lift lift : lifts) {
            int currentFloor = lift.getCurrentFloor();
            int distance = Math.abs(currentFloor - floor);
            boolean isIdle = lift.isIdle();

            // Лог для каждого лифта
            System.out.println("Lift " + lift.getId() + " is on floor " + currentFloor +
                    ", distance to floor " + floor + ": " + distance +
                    ", is idle: " + isIdle);

            if (distance < minDistance && isIdle) {
                minDistance = distance;
                bestLift = lift;
            }
        }

        if (bestLift != null) {
            System.out.println("Best lift for floor " + floor + " is Lift " + bestLift.getId());
        } else {
            System.out.println("All lifts are busy. Choosing the first lift.");
        }

        return (bestLift != null) ? bestLift : lifts.get(0); // Если все лифты заняты, выбираем первый
    }
}
