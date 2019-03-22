package strategypattern;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<Person> peopleByNames = new TreeSet<>(new ComparatorPeopleByNames());
        TreeSet<Person> peopleByAge = new TreeSet<>(new ComparatorPeopleByAge());
        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {

            String[] tokens = scanner.nextLine().split("\\s+");
            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]));

            peopleByNames.add(person);
            peopleByAge.add(person);
        }

        for (Person person : peopleByNames) {
            System.out.println(person.toString());
        }
        for (Person person : peopleByAge) {
            System.out.println(person.toString());
        }
    }
}
