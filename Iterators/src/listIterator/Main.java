package listIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> data = Arrays.stream(scanner.nextLine().split("\\s+"))
                .skip(1)
                .collect(Collectors.toCollection(ArrayList::new));

        ListIterator listIterator = new ListIterator(data);

        String line = scanner.nextLine();
        while (!"END".equals(line)) {

            switch (line) {
                case "Move":
                    System.out.println(listIterator.move());
                    break;

                case "HasNext":
                    System.out.println(listIterator.hasNext());
                    break;

                case "Print":
                    try {
                        System.out.println(listIterator.print());
                    } catch (IndexOutOfBoundsException ibe) {
                        System.out.println(ibe.getMessage());
                    }
                    break;

                case "PrintAll":
                    for (String el : listIterator) {
                        System.out.print(el + " ");
                    }
                    System.out.println();
                    break;
            }

            line = scanner.nextLine();
        }

    }
}
