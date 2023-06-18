package programmers.lv2.matrixmultiplication;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] arr1 = new int[][]{{1, 4}, {3, 2}, {4, 1}};
        int[][] arr2 = new int[][]{{3, 3}, {3, 3}};
        int[][] answer = solution(arr1, arr2);

        for (int[] row : answer) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int row_arr1 = arr1.length;
        int col_arr1 = arr1[0].length;
        int col_arr2 = arr2[0].length;

        int[][] answer = new int[row_arr1][col_arr2];
        for (int j = 0; j < row_arr1; j++) {
            for (int i = 0; i < col_arr2; i++) {
                for (int k = 0; k < col_arr1; k++) {
                    answer[j][i] += arr1[j][k] * arr2[k][i];
                }
            }
        }

        return answer;
    }
}
