package OOP;

public class Plane extends Vehicle {

    public Plane(int mass, double maxSpeed) {
        super(mass, maxSpeed, VehicleType.PLANE);
    }

    @Override
    public void move() {
        System.out.println("Lece w powietrzu");
    }
}
