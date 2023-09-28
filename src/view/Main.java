package view;

import controller.ThreadCar;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Semaphore semaphore = new Semaphore(1);

        for (int car = 0; car < 4; car++) {
            Thread Car = new ThreadCar(car,semaphore);
            Car.start();
        }
    }
}
