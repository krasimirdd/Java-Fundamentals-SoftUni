package ex8;

import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Set<String>> map = new LinkedHashMap<>();

        String line = scanner.nextLine();
        while (!"JOKER".equals(line)) {

            String[] tokens = line.split(": ");
            String name = tokens[0];
            String[] cards = tokens[1].split(", ");

            if (!map.containsKey(name)) {
                Set<String> hand = new HashSet<>();
                Collections.addAll(hand, cards);
                map.put(name, hand);

            } else {
                Collections.addAll(map.get(name), cards);
            }
            line = scanner.nextLine();
        }

        StringBuilder sb = new StringBuilder();
        for (String name : map.keySet()) {
            sb.append(name)
                    .append(": ");

            int score = 0;
            for (String hand : map.get(name)) {

                int times;

                if (hand.charAt(0) == 'J') {
                    times = 11;
                } else if (hand.charAt(0) == 'Q') {
                    times = 12;
                } else if (hand.charAt(0) == 'K') {
                    times = 13;
                } else if (hand.charAt(0) == 'A') {
                    times = 14;
                } else {
                    times = Integer.parseInt(hand.split("[A-Z]")[0]);
                }

                if (hand.endsWith("S")) {
                    score += times * 4;
                } else if (hand.endsWith("H")) {
                    score += times * 3;
                } else if (hand.endsWith("D")) {
                    score += times * 2;
                } else if (hand.endsWith("C")) {
                    score += times;
                }
            }
            sb.append(score)
                    .append(System.lineSeparator());
        }
        System.out.println(sb);
    }
}
