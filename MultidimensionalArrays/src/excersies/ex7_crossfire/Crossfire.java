package excersies.ex7_crossfire;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] size = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = size[0];
        int cols = size[1];

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        int data = 1;
        for (int row = 0; row < rows; row++) {
            ArrayList<Integer> innerList = new ArrayList<>();
            matrix.add(innerList);

            for (int col = 0; col < cols; col++) {
                innerList.add(data++);
            }
        }

        String line = scanner.nextLine();
        while (!line.equals("Nuke it from orbit")) {

            String[] tokens = line.split("\\s+");
            int x = Integer.parseInt(tokens[0]);
            int y = Integer.parseInt(tokens[1]);
            int radius = Integer.parseInt(tokens[2]);

            if (isValid(x, rows, cols) && isValid(y, rows, cols)) {
//                int element = matrix.get(x).get(y);

                int startRow = x - radius;
                int startCol = y + radius;

                ArrayList<ArrayList<Integer>> tempMatrix = new ArrayList<>(matrix);
                for (int i = startCol - radius; i < y + radius; i++) {
                    for (int index = startRow; index < x + radius; index++) {
                        if (startRow >= rows) {
                            break;
                        }
                        if (i > cols) {
                            break;
                        }
                        if (i == y && index == x) {
                            for (int j = y - radius; j < y + radius; j++) {
                                if (tempMatrix.get(x).size() > y - radius) {
                                    if (startCol > cols - 1) {
                                        startCol = cols - 1;
                                    }
                                    tempMatrix.get(x).remove(startCol - j);
                                }
                            }
                            startRow++;
                        } else {
                            if (tempMatrix.get(startRow).size() >= startCol - radius) {
                                tempMatrix.get(startRow++).remove(startCol - radius);
                            } else {
                                startRow++;
                            }
                        }
                        System.out.println();
                    }
                }
                matrix = new ArrayList<>(tempMatrix);
            }

            line = scanner.nextLine();
        }

        for (ArrayList<Integer> integers : matrix) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }


    private static boolean isValid(int a, int rows, int cols) {

        if (a < 0 || a >= rows || a >= cols) {
            return false;
        }
        return true;
    }
}
