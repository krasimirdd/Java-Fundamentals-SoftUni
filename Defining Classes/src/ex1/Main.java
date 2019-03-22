package ex1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Integer lines = Integer.valueOf(scanner.nextLine());
        List<Person> people = new ArrayList<>();

        while (lines-- > 0) {

            String[] data = scanner.nextLine().split("\\s+");
            Person person = new Person(data[0], Integer.parseInt(data[1]));

            if (person.getAge() > 30) {
                people.add(person);
            }
        }

        people.stream()
                .sorted(Comparator.comparing(Person::getName))
                .forEach(person -> System.out.println(person.toString()));
    }
}
