package ex1;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> names = new LinkedHashSet<>();

        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            names.add(scanner.nextLine());
        }

        for (String name : names) {
            System.out.println(name);
        }
    }
}
