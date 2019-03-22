package exam2.ex3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parking {
    private Map<String, Car> cars;
    private int capacity;

    public Parking(int capacity) {
        this.cars = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public Car getCar(String registrationNumber) {
        return this.cars.get(registrationNumber);
    }

    public String addCar(Car car) {

        if (this.cars.containsKey(car.getRegistrationNumber())) {
            return "Car with that registration number, already exists!";
        } else if (this.cars.size() == this.capacity) {
            return "Parking is full!";
        }

        this.cars.putIfAbsent(car.getRegistrationNumber(), car);
        return String.format("Successfully added new car %s %s",
                car.getMake(),
                car.getRegistrationNumber());
    }

    public String removeCar(String registrationNumber) {
        if (!this.cars.containsKey(registrationNumber)) {
            return "Car with that registration number, doesn't exists!";
        }
        this.cars.remove(registrationNumber);
        return String.format("Successfully removed %s", registrationNumber);
    }

    public void removeSetOfRegistrationNumber(List<String> registrationNumbers) {
        registrationNumbers.forEach(this::removeCar);
    }

    public int getCount() {
        return this.cars.size();
    }
}
