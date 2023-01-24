package OOP;

public abstract class Vehicle implements Moveable {

    private int mass;
    private double maxSpeed;
    private VehicleType type;

//    Jeśłi nie ma żadnego konstruktora, to konstruktor poniżej zwany domyślnym
//    istnieje out of the box
//    ale jeśli utworzyłeś jakikolwiek konstruktor, to domyśłny nie jest już potrzebny i przestaje istnieć
//    Jeśli wciąz potrzebujesz domyślny konstruktor, to musisz go już wtedy
//    samodzielnie utworzyć
    public Vehicle() {}

    public Vehicle (int mass, double maxSpeed, VehicleType type) {
        this.mass = mass;
        this.maxSpeed = maxSpeed;
        this.type = type;
    }

    public int getMass() {
        if (mass <= 0) {
            throw new IllegalStateException("Wrong mass");
        }
        if (mass <= 20) {
            System.out.println("Tyle co nic xd");
            return 0;
        }
        return mass;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public VehicleType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "OOP.Vehicle{" +
                "mass=" + mass +
                ", maxSpeed=" + maxSpeed +
                ", type=" + type +
                '}';
    }
}
