package AlgorithmTest.Baekjoon.BOJ9663;

import java.io.*;

public class Main {
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        System.out.println(NQueen(N));

        br.close();
    }

    public static int NQueen(int n) {
        int[][] board = new int[n][n];
        return NQueen(board, 0, 0);
    }

    private static int NQueen(int[][] board, int row, int cnt) {
        int boardSize = board.length;
        System.out.println("실행 횟수 : " + ++count);

        if (row == boardSize) {
            return cnt + 1;
        }

        for (int x = 0; x < boardSize; x++) {
            if (!checkOverlap(board, row, x)) {
                board[row][x] = true;
                cnt = NQueen(board, row + 1, cnt);
                board[row][x] = false;
            }
        }

        return cnt;
    }

    public static boolean checkOverlap(boolean[][] board, int row, int col) {
        int[] dx = {1, -1, -1, 1};
        int[] dy = {1, 1, -1, -1};
        int boardSize = board.length;

        // 수직, 수평 검사
        for (int i = 0; i < boardSize; i++) {
            if (board[row][i] || board[i][col]) {
                return true;
            }
        }
        // 대각선 검사
        for (int i = 0; i < 4; i++) {
            int x = col + dx[i];
            int y = row + dy[i];
            while (x >= 0 && x < boardSize && y >= 0 && y < boardSize) {
                if (board[y][x]) {
                    return true;
                } else {
                    x += dx[i];
                    y += dy[i];
                }
            }
        }

        return false;
    }

    public static void fillBoard(int[][] board, int row, int col, int num){
        int[] dx = {1, -1, -1, 1};
        int[] dy = {1, 1, -1, -1};
        int boardSize = board.length;

        if(row == boardSize){
            return;
        }

        for(int i=0; i<boardSize; i++){
            if(board[row][i] == 0) board[row][i] = num;
            if(board[i][col] == 0) board[i][col] = num;
        }

        for (int i = 0; i < 4; i++) {
            int x = col + dx[i];
            int y = row + dy[i];
            while (x >= 0 && x < boardSize && y >= 0 && y < boardSize) {
                if (board[y][x] == 0) {
                    board[y][x] = num;
                }
                x += dx[i];
                y += dy[i];
            }
        }
    }
}
