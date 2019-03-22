package comparingobjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Person> people = new ArrayList<>();
        while (!input.equals("END")) {

            String[] tokens = input.split("\\s+");

            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
            people.add(person);

            input = scanner.nextLine();
        }

        int n = Integer.parseInt(scanner.nextLine());
        Person comparePerson = people.get(n - 1);

        int equalPeople = (int) people.stream()
                .filter(p -> p.compareTo(comparePerson) == 0)
                .count();

        if (equalPeople == 1) {
            System.out.println("No matches");
        } else {
            System.out.println(String.format("%d %d %d",
                    equalPeople,
                    people.size() - equalPeople,
                    people.size()));
        }
    }
}
