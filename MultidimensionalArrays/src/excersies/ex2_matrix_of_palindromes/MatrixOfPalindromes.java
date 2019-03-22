package excersies.ex2_matrix_of_palindromes;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] rowsNcols = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String[] alphabet = {
                "a", "b", "c", "d", "e", "f", "g", "h", "i",
                "j", "k", "l", "m", "n", "o", "p", "q", "r",
                "s", "t", "u", "v", "w", "x", "y", "z"
        };

        int rows = rowsNcols[0];
        int cols = rowsNcols[1];
        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                matrix[row][col] = alphabet[row] + alphabet[col + row] + alphabet[row];
            }
        }

        System.out.println(showMatrix(matrix).toString());

    }

    private static StringBuilder showMatrix(String[][] matrix) {

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
