package OOP;

public class Bike extends Vehicle {

    public Bike(int mass, double maxSpeed) {
        super(mass, maxSpeed, VehicleType.BIKE);
    }

    @Override
    public void move() {
        System.out.println("Jade w lesie");
    }
}
