package ex5;

import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Robotics {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Deque<String> products = new ArrayDeque<>();

        String[] robotData = scanner.nextLine().split(";");
        String[] robots = new String[robotData.length];
        int[] workingTime = new int[robotData.length];
        int[] processTime = new int[robotData.length];

        for (int i = 0; i < robotData.length; i++) {
            robots[i] = robotData[i].split("-")[0];
            workingTime[i] = Integer.parseInt(robotData[i].split("-")[1]);
        }

        String[] timeData = scanner.nextLine().split(":");
        int hours = Integer.parseInt(timeData[0]);
        int minutes = Integer.parseInt(timeData[1]);
        int seconds = Integer.parseInt(timeData[2]);

        int startTime = hours * 3600 + minutes * 60 + seconds;
        int time = 0;

        String product = scanner.nextLine();
        while (!product.equals("End")) {
            products.offer(product);
            product = scanner.nextLine();
        }

        while (!products.isEmpty()) {
            time++;

            String firstProduct = products.poll();
            boolean isAssigned = false;

            for (int i = 0; i < robots.length; i++) {

                if (processTime[i] == 0 && !isAssigned) {
                    processTime[i] = workingTime[i];
                    printTask(robots[i], startTime + time, firstProduct);
                    isAssigned = true;
                }
                if (processTime[i] > 0) {
                    processTime[i]--;
                }
            }
            if (!isAssigned) {
                products.offer(firstProduct);
            }
        }
    }

    private static void printTask(String robot, int time, String firstProduct) {

        int hours = (time / 3600) % 24;
        int minutes = time % 3600 / 60;
        int seconds = time % 60;

        DecimalFormat df = new DecimalFormat("00");
        System.out.println(String
                .format("%s - %s [%s:%s:%s]",
                        robot,
                        firstProduct,
                        df.format(hours),
                        df.format(minutes),
                        df.format(seconds))
        );
    }
}

