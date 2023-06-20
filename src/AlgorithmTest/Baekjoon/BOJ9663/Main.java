package AlgorithmTest.Baekjoon.BOJ9663;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        System.out.println(nQueen(N));

        br.close();
    }

    public static int nQueen(int n) {
        int[] board = new int[n];
        return nQueen(board, 0, 0);
    }

    private static int nQueen(int[] board, int depth, int cnt) {
        if (depth == board.length) {
            return cnt + 1;
        }

        for (int i = 1; i <= board.length; i++) {
            boolean flag = true;
            for (int j = 0; j < depth; j++) {
                if (board[j] == i || board[j] == i + (depth - j) || board[j] == i - (depth - j)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                board[depth] = i;
                cnt = nQueen(board, depth + 1, cnt);
                board[depth] = 0;
            }
        }

        return cnt;
    }
}
