package ex7;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Integer> sequence = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> smallestOne = arr ->
                arr.lastIndexOf(arr.stream().min(Integer::compareTo).get());

        System.out.println(smallestOne.apply(sequence));
    }
}
