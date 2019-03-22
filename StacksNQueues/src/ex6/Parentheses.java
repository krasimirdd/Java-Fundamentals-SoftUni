package ex6;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Parentheses {
    static boolean isBalanced = true;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Deque<Character> openingBrackets = new ArrayDeque<>();

        String parentheses = scanner.nextLine();

        for (int i = 0; i < parentheses.length(); i++) {

            char curr = parentheses.charAt(i);
            if (curr == '[' || curr == '{' || curr == '(') {
                openingBrackets.push(curr);
            } else {
                if (openingBrackets.isEmpty()) {
                    isBalanced = false;
                    break;
                }

                char opening = openingBrackets.pop();
                checkBalanced(curr, opening);
            }
        }
        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static void checkBalanced(char curr, char opening) {
        if (curr == '}' && opening != '{') {
            isBalanced = false;
        } else if (curr == ']' && opening != '[') {
            isBalanced = false;
        } else if (curr == ')' && opening != '(') {
            isBalanced = false;
        }
    }
}
