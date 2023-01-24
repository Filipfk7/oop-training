package OOP;

public class GoodApplication {
    public static void main(String[] args) {
        Vehicle vehicle = generatePlane();
        System.out.println(vehicle);
        vehicle.move();
    }

    private static Car generateCar() {
        return new Car(2000,  250);
    }

    private static Plane generatePlane() {
        return new Plane(10000, 400);
    }
}
