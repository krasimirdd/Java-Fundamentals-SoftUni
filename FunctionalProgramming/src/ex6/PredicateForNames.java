package ex6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateForNames {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int lenght = Integer.parseInt(scanner.nextLine());
        ArrayList<String> names = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayList::new));

        Predicate<String> chekLenght = n -> n.length() <= lenght;
        Consumer<List<String>> printer = col -> col.forEach(System.out::println);

        List<String> result = names.stream().filter(chekLenght).collect(Collectors.toList());
        printer.accept(result);

    }
}
