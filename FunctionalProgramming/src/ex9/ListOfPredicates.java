package ex9;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOfPredicates {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int range = Integer.parseInt(scanner.nextLine());

        Set<Integer> sequence = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        Function<Integer, ArrayList<Integer>> getNumbersInRange =
                (r -> {
                    ArrayList<Integer> numbers = new ArrayList<>();
                    int i = 1;
                    while (i <= r) {
                        numbers.add(i++);
                    }
                    return numbers;
                });
        ArrayList<Integer> numbers = new ArrayList<>(getNumbersInRange.apply(range));

        List<Predicate<Integer>> predicates = new ArrayList<>();
        sequence.forEach(el -> predicates.add(num -> num % el == 0));

        for (Predicate<Integer> predicate : predicates) {
            numbers = numbers.stream().filter(predicate::test).collect(Collectors.toCollection(ArrayList::new));
        }

        Consumer<ArrayList<Integer>> printer = integer -> integer.forEach(i -> System.out.print(i + " "));
        printer.accept(numbers);
    }
}