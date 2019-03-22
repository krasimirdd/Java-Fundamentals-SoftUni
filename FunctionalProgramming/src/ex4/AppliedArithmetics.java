package ex4;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class AppliedArithmetics {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] intput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String line = scanner.nextLine();

        Function<int[], int[]> add = arr -> Arrays.stream(arr).map(el -> ++el).toArray();
        UnaryOperator<int[]> subtract = arr -> Arrays.stream(arr).map(el -> --el).toArray();
        UnaryOperator<int[]> multiply = arr -> Arrays.stream(arr).map(el -> el * 2).toArray();
        Consumer<int[]> printer = arr -> Arrays.stream(arr).forEach(el -> System.out.print(el + " "));

        while (!"end".equals(line)) {

            switch (line) {
                case "add":
                    intput = add.apply(intput);
                    break;
                case "subtract":
                    intput = subtract.apply(intput);
                    break;
                case "multiply":
                    intput = multiply.apply(intput);
                    break;
                default:
                    printer.accept(intput);
                    System.out.println();
                    break;
            }
            line = scanner.nextLine();
        }
    }
}
