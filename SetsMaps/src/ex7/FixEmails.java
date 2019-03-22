package ex7;

import java.util.*;

public class FixEmails {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, String> emailBook = new LinkedHashMap<>();

        String line = scanner.nextLine();
        while (!"stop".equals(line)) {

            String email = scanner.nextLine();
            emailBook.put(line, email);

            line = scanner.nextLine();
        }

        Set<String> toRemove = new HashSet<>();
        emailBook.forEach((n, e) -> {
            String[] emailtokens = e.split("\\.");

            if ("us".equalsIgnoreCase(emailtokens[1]) ||
                    "uk".equalsIgnoreCase(emailtokens[1]) ||
                    "com".equalsIgnoreCase(emailtokens[1])) {
                toRemove.add(n);
            }
        });

        toRemove.forEach(emailBook::remove);
        emailBook.forEach((n, e) -> System.out.println(n + " -> " + e));
    }
}
