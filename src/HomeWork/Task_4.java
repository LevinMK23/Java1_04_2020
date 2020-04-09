package HomeWork;

import java.util.Arrays;

public class Task_4  {

    public static void main(String[] args) {
        int n = 6, c = n-1;
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i] == matrix[j]) {
                    matrix[i][j] = 1;
                } else if (j == c){
                    matrix[i][j] = 1;
                    c--;
                }
            }
        }
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
