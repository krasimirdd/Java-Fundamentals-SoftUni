package ex3;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        Set<String> elements = new TreeSet<>();

        while (count-- > 0) {

            String[] line = scanner.nextLine().split(" ");
            elements.addAll(Arrays.asList(line));
        }

        elements.forEach(e -> System.out.print(e + " "));
    }
}
