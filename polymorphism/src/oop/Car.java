package oop;

public class Car extends Vehicle {

    public Car(int mass, double maxSpeed) {
        super(mass, maxSpeed, VehicleType.CAR);
    }

    @Override
    public void move() {
        System.out.println("Jade po ulicy");
    }
}
