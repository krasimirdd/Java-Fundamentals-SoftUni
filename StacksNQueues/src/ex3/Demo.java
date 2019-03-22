package ex3;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int max = 0;

        for (int i = 0; i <= n; i++) {

            String[] log = scanner.nextLine().split("\\s+");
            String command = log[0];

            switch (command) {
                case "1":
                    Integer element = Integer.valueOf(log[1]);
                    if (element >= max) {
                        max = element;
                    }
                    stack.push(element);
                    break;

                case "2":
                    if (!stack.isEmpty()) {
                        max = stack.peekFirst();
                        Integer curr = stack.pop();
                        if (curr == max && !stack.isEmpty()) {
                            max = stack.peek();
                            break;
                        }
                        max = 0;
                        break;
                    }
                    throw new Exception("Empty stack!");

                case "3":
                    System.out.println(max);
                    break;

                default:
                    break;
            }
        }
    }
}

