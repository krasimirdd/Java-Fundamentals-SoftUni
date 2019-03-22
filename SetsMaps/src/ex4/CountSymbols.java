package ex4;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        char[] text = scanner.nextLine().toCharArray();
        Map<Character, Integer> map = new TreeMap<>();

        for (int i = 0; i < text.length; i++) {

            Integer count = map.getOrDefault(text[i], 0);
            map.put(text[i], count + 1);
        }

        for (Character character : map.keySet()) {
            System.out.println(character + ": " + map.get(character) + " time/s");

        }
    }
}
