package excersies.ex5_matrix_shuffling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = size[0];
        int cols = size[1];

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] rowData = scanner.nextLine().split("\\s+");

            for (int col = 0; col < cols; col++) {
                matrix[row][col] = rowData[col];
            }
        }

        String command = scanner.nextLine();
        while (!command.equals("END")) {

            String[] tokens = command.split("\\s+");
            if (tokens[0].equals("swap") && tokens.length == 5) {
                ArrayList<Integer> indexes = new ArrayList<>();

                for (int i = 1; i < tokens.length; i++) {
                    indexes.add(Integer.valueOf(tokens[i]));
                }

                if (swapElements(matrix, indexes)) {
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            System.out.print(matrix[i][j] + " ");
                        }
                        System.out.println();
                    }
                }
            } else {
                System.out.println("Invalid input!");
            }
            command = scanner.nextLine();
        }
    }

    private static boolean swapElements(String[][] matrix, ArrayList<Integer> indexes) {
        Integer f_el_X = indexes.get(0);
        Integer f_el_Y = indexes.get(1);
        Integer s_el_X = indexes.get(2);
        Integer s_el_Y = indexes.get(3);

        if (f_el_X < 0 || f_el_Y < 0 || s_el_X < 0 || s_el_Y < 0
                || f_el_X >= matrix.length || f_el_Y >= matrix[0].length
                || s_el_X >= matrix.length || s_el_Y >= matrix[0].length) {

            System.out.println("Invalid input!");
            return false;
        }

        String curr = matrix[indexes.get(0)][indexes.get(1)];
        matrix[indexes.get(0)][indexes.get(1)] = matrix[indexes.get(2)][indexes.get(3)];
        matrix[indexes.get(2)][indexes.get(3)] = curr;
        return true;
    }
}
