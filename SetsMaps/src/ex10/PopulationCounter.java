package ex10;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Long>> countries = new LinkedHashMap<>();
        Map<String, Long> populationByCountry = new LinkedHashMap<>();

        String line = scanner.nextLine();
        while (!"report".equals(line)) {

            String[] data = line.split("\\|");
            String country = data[1];
            String city = data[0];
            long population = Integer.valueOf(data[2]);

            if (!countries.containsKey(country)) {

                LinkedHashMap<String, Long> cities = new LinkedHashMap<>();
                countries.put(country, cities);
            } else {
                if (!countries.get(country).containsKey(city)) {
                    countries.get(country).put(city, population);
                }
            }
            if (!populationByCountry.containsKey(country)) {
                populationByCountry.put(country, 0L);
            }
            countries.get(country).put(city, population);
            populationByCountry.put(country, populationByCountry.get(country) + population);

            line = scanner.nextLine();
        }

        StringBuilder sb = new StringBuilder();
        populationByCountry.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEach(e -> {
                    String currCountry = e.getKey();
                    sb.append(currCountry)
                            .append(" (total population: ")
                            .append(e.getValue())
                            .append(")")
                            .append(System.lineSeparator());

                    countries.get(currCountry).entrySet().stream()
                            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                            .forEach(c -> {
                                String city = c.getKey();
                                sb.append("=>")
                                        .append(city)
                                        .append(": ")
                                        .append(c.getValue())
                                        .append(System.lineSeparator());
                            });
                });
        System.out.println(sb);
    }
}
