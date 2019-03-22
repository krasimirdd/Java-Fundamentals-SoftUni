package ex5;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Engine> engineMap = new LinkedHashMap<>();
        List<Car> cars = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int enginesCount = Integer.parseInt(scanner.nextLine());

        while (enginesCount-- > 0) {
            Engine engine = null;
            String[] data = scanner.nextLine().split("\\s+");
            Integer power = Integer.parseInt(data[1]);

            switch (data.length) {
                case 2:
                    engineMap.put(data[0], new Engine(data[0], power));
                    break;
                case 3:
                    try {
                        Integer displacement = Integer.valueOf(data[2]);
                        engineMap.put(data[0], new Engine(data[0], power, displacement));
                    } catch (NumberFormatException nfe) {
                        engineMap.put(data[0], new Engine(data[0], power, data[2]));
                    }
                    break;

                case 4:
                    engineMap.put(data[0], new Engine(data[0], power, Integer.valueOf(data[2]), data[3]));
                    break;
            }
        }

        int carsCount = Integer.parseInt(scanner.nextLine());

        while (carsCount-- > 0) {
            Car car = null;
            String[] data = scanner.nextLine().split("\\s+");
            Engine engine = engineMap.get(data[1]);

            switch (data.length) {
                case 2:
                    cars.add(new Car(data[0], engine));
                    break;

                case 3:
                    try {
                        Integer weight = Integer.valueOf(data[2]);
                        cars.add(new Car(data[0], engine, weight));
                    } catch (NumberFormatException nfe) {
                        cars.add(new Car(data[0], engine, data[2]));
                    }
                    break;

                case 4:
                    cars.add(new Car(data[0], engine, Integer.valueOf(data[2]), data[3]));
                    break;
            }
        }

        cars.forEach(System.out::println);

    }
}
