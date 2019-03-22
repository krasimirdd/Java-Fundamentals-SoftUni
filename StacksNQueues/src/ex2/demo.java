package ex2;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class demo {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);
        int x = Integer.parseInt(input[2]);

        input = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> nums = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            nums.push(Integer.valueOf(input[i]));
        }
        for (int i = 0; i < s; i++) {
            nums.pop();
        }
        if (nums.isEmpty()) {
            System.out.println(0);
        } else if (nums.contains(x)) {
            System.out.println("true");
        } else {
            Collections.sort(Arrays.asList(nums), Collections.reverseOrder());
            Integer min = nums.peek();
            System.out.println(min);
        }
    }
}
