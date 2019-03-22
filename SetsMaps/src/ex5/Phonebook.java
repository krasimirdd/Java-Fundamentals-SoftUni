package ex5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, String> phonebook = new HashMap<>();

        String line = scanner.nextLine();
        while (!"search".equals(line)) {
            String[] input = line.split("-");

            phonebook.put(input[0], input[1]);
            line = scanner.nextLine();
        }

        line = scanner.nextLine();
        while (!"stop".equals(line)) {

            if (!phonebook.containsKey(line)) {
                System.out.println("Contact " + line + " does not exist.");
            } else {
                System.out.println(line + " -> "+ phonebook.get(line));
            }

            line = scanner.nextLine();
        }
    }
}
