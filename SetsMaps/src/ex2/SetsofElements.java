package ex2;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsofElements {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] data = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int fSize = data[0];
        int sSize = data[0];

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();
        while (fSize-- > 0) {
            firstSet.add(Integer.parseInt(scanner.nextLine()));
        }
        while (sSize-- > 0) {
            secondSet.add(Integer.valueOf(scanner.nextLine()));
        }

        firstSet.retainAll(secondSet);
        firstSet.forEach(e -> System.out.print(e + " "));
    }
}
