package ex5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));

        int n = Integer.parseInt(scanner.nextLine());

        BiFunction<ArrayList<Integer>, Integer, ArrayList<Integer>> reverseAndExclude =
                ((arr, num) -> {
                    Collections.reverse(arr);

                    return arr.stream().filter(el -> el % num != 0)
                            .collect(Collectors.toCollection(ArrayList::new));
                });

        Consumer<ArrayList<Integer>> printer = e ->
                e.forEach(value -> System.out.print(value + " "));

        printer.accept(reverseAndExclude.apply(numbers, n));
    }
}
