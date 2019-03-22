package ex10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.asList(scanner.nextLine().split("\\s+"));

        Function<List<String>, StringBuilder> getResult = (list -> {
            StringBuilder result = new StringBuilder();

            if (list.size() > 0) {
                list.forEach(el -> result.append(el).append(", "));
                result.deleteCharAt(result.length() - 2);
                result.append("are going to the party!");

            } else {
                result.append("Nobody is going to the party!");
            }

            return result;
        });

        String line = scanner.nextLine();
        while (!"Party!".equals(line)) {

            String[] command = line.split("\\s+");

            Predicate<String> startingWith = s -> !s.startsWith(command[2]);
            Predicate<String> endingWith = s -> !s.endsWith(command[2]);
            Predicate<String> lengthIs = s -> s.length() == Integer.parseInt(command[2]);

            if ("Remove".equals(command[0])) {

                switch (command[1].toLowerCase()) {

                    case "startswith":
                        names = names.stream()
                                .filter(startingWith)
                                .collect(Collectors.toList());

                        break;

                    case "endswith":
                        names = names.stream()
                                .filter(endingWith)
                                .collect(Collectors.toList());
                        break;

                    case "length":
                        names = names.stream()
                                .filter(lengthIs)
                                .collect(Collectors.toList());
                }
            } else {
                ArrayList<String> returnNames = new ArrayList<>(names);
                Function<List<String>, ArrayList<String>> doubleIfStartingWith = ((list) -> {

                    list.forEach(n -> {
                        if (!startingWith.test(n)) {
                            returnNames.add(list.indexOf(n), n);
                        }
                    });

                    return new ArrayList<>(returnNames);
                });
                Function<List<String>, ArrayList<String>> doubleIfEndingWith = ((list) -> {

                    list.forEach(n -> {
                        if (!endingWith.test(n)) {
                            returnNames.add(list.indexOf(n), n);
                        }
                    });

                    return new ArrayList<>(returnNames);
                });
                Function<List<String>, ArrayList<String>> doubleIfLengthIs = ((list) -> {

                    list.forEach(n -> {
                        if (lengthIs.test(n)) {
                            returnNames.add(list.indexOf(n), n);
                        }
                    });

                    return new ArrayList<>(returnNames);
                });

                switch (command[1].toLowerCase()) {
                    case "startswith":
                        names = doubleIfStartingWith.apply(names);
                        break;

                    case "endswith":
                        names = doubleIfEndingWith.apply(names);
                        break;

                    case "length":
                        names = doubleIfLengthIs.apply(names);
                        break;
                }
            }

            line = scanner.nextLine();
        }

        System.out.println(getResult.apply(names).toString());
    }
}
