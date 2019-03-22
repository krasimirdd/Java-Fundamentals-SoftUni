package excersies.ex1_fill_the_matrix;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int dimensions = Integer.parseInt(input[0]);
        String type = input[1].toLowerCase();

        int[][] matrix = createMatrix(dimensions);

        if (type.equals("a")) {
            fillTypeA(matrix);
        } else if (type.equals("b")) {
            fillTypeB(matrix);
        }

        System.out.println(showMatrix(matrix).toString());
    }

    private static int[][] createMatrix(int dimensions) {
        return new int[dimensions][dimensions];
    }

    private static void fillTypeA(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int rowEntity = 1;
        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {

                matrix[row][col] = rowEntity;
                rowEntity++;
            }
        }
    }

    private static void fillTypeB(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int col = 0;
        int rowEntity = 1;

        for (col = 0; col < cols; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < rows; row++) {

                    matrix[row][col] = rowEntity;
                    rowEntity++;
                }
            } else {
                for (int row = rows - 1; row >= 0; row--) {

                    matrix[row][col] = rowEntity;
                    rowEntity++;
                }
            }
        }
    }

    private static StringBuilder showMatrix(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        StringBuilder output = new StringBuilder();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                output.append(matrix[row][col])
                        .append(" ");
            }
            output.append(System.lineSeparator());
        }
        return output;
    }
}
