package controller;

import java.util.concurrent.Semaphore;

public class ThreadCar extends Thread {
    private int CarID;
    private Semaphore semaphore;

    public ThreadCar(int carID, Semaphore semaphore) {
        this.CarID = carID;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            Cruzamento();
        } catch (Exception e) {
            //
        } finally {
            semaphore.release();
        }
    }

    private void Cruzamento() {
        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        switch (CarID) {
            case 0 -> System.out.println("Carro do Norte Passou para o Sul");
            case 1 -> System.out.println("Carro do Oeste Passou para o Leste");
            case 2 -> System.out.println("Carro do Leste Passou para o Oeste");
            case 3 -> System.out.println("Carro do Sul Passou para o Norte");
        }
    }
}
