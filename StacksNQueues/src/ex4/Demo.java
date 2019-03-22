package ex4;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Demo {
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");

        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);
        int x = Integer.parseInt(input[2]);

        String[] nums = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            numbers.add(Integer.valueOf(nums[i]));
        }
        for (int i = 0; i < s; i++) {
            numbers.poll();
        }
        if (numbers.contains(x)) {
            System.out.println(true);
        } else {
            if (s == nums.length) {
                System.out.println("0");
            } else {
                for (Integer number : numbers) {
                    min = findMin(number);
                }

                System.out.println(min);
            }
        }
    }

    private static int findMin(Integer number) {
        if (number < min) {
            min = number;
        }
        return min;
    }
}
