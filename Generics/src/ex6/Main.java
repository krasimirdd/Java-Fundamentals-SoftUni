package ex6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Box<Double>> boxList = new ArrayList<>();

        while (n-- > 0) {
            String line = scanner.nextLine();

            boxList.add(new Box<>(Double.parseDouble(line)));
        }

        Box<Double> comparatorBox = new Box<>(Double.parseDouble(scanner.nextLine()));

        System.out.println(countGreaterValues(boxList, comparatorBox));
    }

    static <T extends Comparable<T>> int countGreaterValues(List<Box<T>> list, Box<T> box) {
        int counter = 0;

        for (Box<T> o : list) {
            if (o.compareTo(box) > 0) {
                counter++;
            }
        }

        return counter;
    }
}
