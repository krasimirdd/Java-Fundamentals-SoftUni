package excersies.ex3_diagonal_difference;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[rows][rows];
        fillMatrix(matrix);

        System.out.println(
                Math.abs(sumMainDiagonal(matrix) - sumSecondaryDiagonal(matrix)));
    }

    private static int sumSecondaryDiagonal(int[][] matrix) {
        int rows = matrix.length;
        int sum = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < rows; col++) {

                if (row + col == rows - 1) {
                    sum += matrix[row][col];
                }
            }
        }

        return sum;
    }

    private static int sumMainDiagonal(int[][] matrix) {

        int rows = matrix.length;
        int sum = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < rows; col++) {

                if (row == col) {
                    sum += matrix[row][col];
                }
            }
        }
        return sum;
    }

    private static void fillMatrix(int[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            int[] data = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int col = 0; col < matrix.length; col++) {
                matrix[row][col] = data[col];
            }
        }
    }
}
