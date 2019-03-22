package excersies.ex6_matrix_rotation;

import java.util.ArrayList;
import java.util.Scanner;

public class MatrixRotation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] rotateData = scanner.nextLine().split("[()]+");

        int degrees = Integer.parseInt(rotateData[1]) % 360;
        ArrayList<String> inputString = new ArrayList<>();
        String line = scanner.nextLine();
        int maxLine = line.length();

        while (!line.equals("END")) {
            inputString.add(line);
            line = scanner.nextLine();

            if (line.length() > maxLine) {
                maxLine = line.length();
            }
        }

        char[][] matrix = new char[inputString.size()][maxLine];

        for (int r = 0; r < inputString.size(); r++) {
            for (int c = 0; c < maxLine; c++) {

                if (c > inputString.get(r).length() - 1) {
                    matrix[r][c] = ' ';
                } else {
                    matrix[r][c] = inputString.get(r).charAt(c);
                }
            }
        }

        if (degrees == 90) {
            for (int c = 0; c < maxLine; c++) {
                for (int r = matrix.length - 1; r >= 0; r--) {
                    System.out.print(matrix[r][c]);
                }
                System.out.println();
            }
        } else if (degrees == 180) {
            for (int r = matrix.length - 1; r >= 0; r--) {
                for (int c = maxLine - 1; c >= 0; c--) {
                    System.out.print(matrix[r][c]);
                }
                System.out.println();
            }
        } else if (degrees == 270) {
            for (int c = maxLine - 1; c >= 0; c--) {
                for (int r = 0; r < matrix.length; r++) {
                    System.out.print(matrix[r][c]);
                }
                System.out.println();
            }
        } else {
            for (int r = 0; r < matrix.length; r++) {
                for (int c = 0; c < maxLine; c++) {
                    System.out.print(matrix[r][c]);
                }
                System.out.println();
            }
        }
    }
}
