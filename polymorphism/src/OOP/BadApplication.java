package OOP;

public class BadApplication {
    public static void main(String[] args) {
        Plane plane = new Plane(10000, 400);
        System.out.println(plane);
        plane.move();
    }
}
