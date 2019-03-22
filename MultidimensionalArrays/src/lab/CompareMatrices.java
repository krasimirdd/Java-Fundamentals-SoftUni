package lab;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int[][] firstMatrix = initializeMatrix();
        int[][] secondMatrix = initializeMatrix();

        System.out.println(compare(firstMatrix, secondMatrix) ? "equal" : "not equal");
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

    private static boolean compare(int[][] f, int[][] s) {

        if (f[0].length != s[0].length || f.length != s.length) {
            return false;
        } else {
            for (int i = 0; i < f.length; i++) {
                for (int j = 0; j < f[0].length; j++) {

                    if (f[i][j] != s[i][j]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
