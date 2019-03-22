package ex9;

import java.util.*;

public class UserLogs {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, List<String>>> log = new TreeMap<>();

        String line = scanner.nextLine();
        while (!"end".equals(line)) {

            String[] tokens = line.split("\\s+");
            String ip = tokens[0].split("=")[1];
            String message = tokens[1].split("=")[1];
            String user = tokens[2].split("=")[1];

            if (!log.containsKey(user)) {

                Map<String, List<String>> userData = new LinkedHashMap<>();

                userData.put(ip, new LinkedList<>());
                log.put(user, userData);

            } else {
                if (!log.get(user).containsKey(ip)) {
                    log.get(user).put(ip, new LinkedList<>());
                }
            }
            log.get(user).get(ip).add(message);

            line = scanner.nextLine();
        }

        StringBuilder output = new StringBuilder();
        for (String user : log.keySet()) {
            output.append(user)
                    .append(": ")
                    .append(System.lineSeparator());

            for (String ip : log.get(user).keySet()) {
                output.append(ip)
                        .append(" => ")
                        .append(log.get(user).get(ip).size())
                        .append(", ");
            }
            int index = output.lastIndexOf(",");
            output.replace(index, output.length(), ".");
            output.append(System.lineSeparator());
        }
        System.out.println(output);
    }
}
