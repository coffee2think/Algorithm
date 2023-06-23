package AlgorithmTest.Baekjoon.BOJ2580;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] board = new int[9][9];
        for (int y = 0; y < 9; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < 9; x++) {
                board[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        sudoku(board, 0, 0);
        br.close();
    }

    public static void sudoku(int[][] board, int row, int col) {
        if (col == 9) {
            sudoku(board, row + 1, 0);
            return;
        }

        if (row == 9) {
            StringBuilder sb = new StringBuilder();
            for (int y = 0; y < 9; y++) {
                for (int x = 0; x < 9; x++) {
                    sb.append(board[y][x]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }

        if (board[row][col] == 0) {
            for (int n = 1; n < 10; n++) {
                if (isPromising(board, row, col, n)) {
                    board[row][col] = n;
                    sudoku(board, row, col + 1);
                    board[row][col] = 0;
                }
            }
        } else {
            sudoku(board, row, col + 1);
        }
    }

    public static boolean isPromising(int[][] board, int row, int col, int n) {
        for (int i = 0; i < 9; i++) {
            int groupX = col / 3 * 3 + i % 3;
            int groupY = row / 3 * 3 + i / 3;
            if (board[row][i] == n || board[i][col] == n || board[groupY][groupX] == n)
                return false;
        }

        return true;
    }
}
