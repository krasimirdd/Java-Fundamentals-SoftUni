package excersies.ex4_maximum_sum;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] matrix = createMatrix(dimensions);

        int maxSum = Integer.MIN_VALUE;
        int sum;
        int[][] templateMatrix = new int[3][3];
        int[][] soutMatrix = new int[3][3];

        //minavame prez cqlata vhodna matrica, kato indexite zapochvat ot 2 zaradi goleminata na template-matricata
        for (int i = 0; i < dimensions[0] - 2; i++) {
            for (int j = 0; j < dimensions[1] - 2; j++) {

                sum = sumElementsFromInnerMatrix(templateMatrix, matrix, i, j);

                //ako sumata e po-golqma ot predishnata q zapazvame i populvame elementite v nova matrica gotova za sout
                if (sum > maxSum) {
                    maxSum = sum;
                    soutMatrix = copyToMemory(templateMatrix);
                }
            }
        }

        System.out.println("Sum = " + maxSum);
        printMatrix(soutMatrix);
    }

    private static void printMatrix(int[][] soutMatrix) {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                output.append(soutMatrix[i][j])
                        .append(" ");
            }
            output.append(System.lineSeparator());
        }

        System.out.println(output);
    }

    private static int[][] copyToMemory(int[][] templateMatrix) {
        int[][] copy = new int[3][3];

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                copy[r][c] = templateMatrix[r][c];
            }
        }

        return copy;
    }

    //populvame matricata vzimame sumata na chlenovete i
    private static int sumElementsFromInnerMatrix(int[][] innerMatrix, int[][] matrix, int i, int j) {
        int sum = 0;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {

                innerMatrix[row][col] = matrix[i + row][j + col];
                sum += innerMatrix[row][col];

            }
        }

        return sum;
    }

    private static int[][] createMatrix(int[] dimensions) {
        int rows = dimensions[0];
        int cols = dimensions[1];
        int[][] matrix = new int[rows][cols];

        populateMatrix(matrix);
        return matrix;
    }

    private static void populateMatrix(int[][] matrix) {


        for (int row = 0; row < matrix.length; row++) {
            int[] data = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int col = 0; col < matrix[0].length; col++) {
                matrix[row][col] = data[col];
            }
        }
    }
}
