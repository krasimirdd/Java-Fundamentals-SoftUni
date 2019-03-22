package lab;

import java.util.Arrays;
import java.util.Scanner;

public class PositionOf {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int[][] matrix = initializeMatrix();
        int number = Integer.parseInt(sc.nextLine());

        String positions = "";
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {

                if (number == matrix[row][col]) {
                    positions += row + " " + col + "\n";
                }
            }
        }
        if (positions.equals("")) {
            positions += "not found";
        }
        System.out.println(positions);

    }

    private static int[][] initializeMatrix() {

        int[] dimensions = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];
        return readMatrix(matrix, rows, cols);

    }

    private static int[][] readMatrix(int[][] matrix, int rows, int cols) {

        for (int row = 0; row < rows; row++) {
            int[] columnData = Arrays.stream(sc.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int col = 0; col < cols; col++) {
                matrix[row][col] = columnData[col];
            }
        }
        return matrix;
    }
}
