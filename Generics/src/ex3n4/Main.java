package ex3n4;

import ex1n2.Box;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        List<Box<Integer>> boxOfIntegers = new ArrayList<>();
        List<Box<String>> boxOfStrings = new ArrayList<>();

        int lines = Integer.parseInt(scanner.nextLine());

        while (lines-- > 0) {

            String line = scanner.nextLine();
            Box<String> box = new Box<>(line);
            boxOfStrings.add(box);
//            try {
//                int number = Integer.parseInt(line);
//                boxOfIntegers.add(new Box<>(number));
//            } catch (Exception e) {
//                boxOfStrings.add(new Box<>(line));
//            }
        }

        int[] indexes = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

//        if (boxOfIntegers.isEmpty()) {
        swapValues(boxOfStrings, indexes[0], indexes[1]);
        boxOfStrings.forEach(System.out::println);
//        } else {
//            swapValues(boxOfIntegers, indexes[0], indexes[1]);
//            boxOfIntegers.forEach(System.out::println);
//        }
    }

    public static <G> void swapValues(List<G> list, int f_index, int s_index) {
        G temp = list.get(f_index);
        list.set(f_index, list.get(s_index));
        list.set(s_index, temp);
    }
}
