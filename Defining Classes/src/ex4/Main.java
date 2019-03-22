package ex4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();

        while (lines-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");


            String model = data[0];
            Integer engineSpeed = Integer.valueOf(data[1]);
            Integer enginePower = Integer.valueOf(data[2]);
            Integer cargoWeight = Integer.valueOf(data[3]);
            String cargoType = data[4];
            Double tire1Pressure = Double.valueOf(data[5]);
            Integer tire1Age = Integer.valueOf(data[6]);
            Double tire2Pressure = Double.valueOf(data[7]);
            Integer tire2Age = Integer.valueOf(data[8]);
            Double tire3Pressure = Double.valueOf(data[9]);
            Integer tire3Age = Integer.valueOf(data[10]);
            Double tire4Pressure = Double.valueOf(data[11]);
            Integer tire4Age = Integer.valueOf(data[12]);

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Tire tire1 = new Tire(tire1Pressure, tire1Age);
            Tire tire2 = new Tire(tire2Pressure, tire2Age);
            Tire tire3 = new Tire(tire3Pressure, tire3Age);
            Tire tire4 = new Tire(tire4Pressure, tire4Age);
            List<Tire> tires = new ArrayList<>(
                    Arrays.asList(tire1, tire2, tire3, tire4)
            );

            cars.add(new Car(model, engine, cargo, tires));
        }

        switch (scanner.nextLine()) {
            case "fragile":
                for (Car car : cars) {
                    if (car.getCargo().getType().equals("fragile")) {
                        for (Tire tire : car.getTires()) {
                            if (tire.getPressure() < 1) {
                                System.out.println(car.getModel());
                                break;
                            }
                        }
                    }
                }
                break;

            case "flamable":
                for (Car car : cars) {
                    if (car.getCargo().getType().equals("flamable")) {
                        if (car.getEngine().getPower() > 250) {
                            System.out.println(car.getModel());
                        }
                    }
                }
                break;
        }
    }
}
