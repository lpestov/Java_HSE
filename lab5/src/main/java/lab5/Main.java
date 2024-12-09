package lab5;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Lift lift1 = new Lift(1);
        Lift lift2 = new Lift(2);

        ElevatorManager manager = new ElevatorManager(Arrays.asList(lift1, lift2));

        Thread liftThread1 = new Thread(lift1);
        Thread liftThread2 = new Thread(lift2);
        Thread requestGenerator = new Thread(new RequestGenerator(manager));

        liftThread1.start();
        liftThread2.start();
        requestGenerator.start();
    }
}
