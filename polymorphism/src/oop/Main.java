package oop;

public class Main {
    public static void main(String[] args) {
        //Lambda można nazwać bardziej nowoczesną / sexy wersją klasy anonimowej
        Vehicle prototype = new Vehicle() { //klasa anonimowa
            @Override
            public void move() {
                System.out.println("Jestem niedziałającym prototypem");
            }
            @Override
            public String toString() {
                return "OOP.Vehicle: Random prototyp";
            }
        };
        prototype.move();
        System.out.println(prototype);

        Car car = new Car(999,100);
        car.move();
        System.out.println(car);

        Vehicle plane = new Plane(10000, 400);
        System.out.println(plane);

        Moveable moveable = new Bike(10, 40);
        moveable.move();
    }
}