package ex6;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> resources = new LinkedHashMap<>();

        String line = scanner.nextLine();
        while (!"stop".equals(line)) {

            Integer quantity = Integer.valueOf(scanner.nextLine());
            Integer currQuantity = resources.getOrDefault(line, 0);
            resources.put(line, quantity + currQuantity);

            line = scanner.nextLine();
        }

        resources.forEach((s, integer) -> System.out.println(s + " -> " + integer));
    }
}
