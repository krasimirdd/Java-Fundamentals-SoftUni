package stackIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Stack<Integer> stack = new Stack<>();

        String input = scanner.nextLine();
        while (!"END".equals(input)) {

            if (input.contains("Push")) {
                Arrays.stream(input.split("([, ]+)"))
                        .skip(1)
                        .mapToInt(Integer::parseInt)
                        .forEach(stack::push);
            } else {
                try {
                    stack.pop();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            input = scanner.nextLine();
        }
        for (int i = 0; i < 2; i++) {
            for (Integer integer : stack) {
                System.out.println(integer);
            }
        }
    }
}
