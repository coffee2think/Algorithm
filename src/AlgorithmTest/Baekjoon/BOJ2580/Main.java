package AlgorithmTest.Baekjoon.BOJ2580;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //스도쿠 데이터 입력
        int[][] board = new int[9][9];
        int zerocount = 0;
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 0) zerocount++;
            }
        }

        while (zerocount != 0) {
            for (int y = 0; y < 9; y++) {
                for (int x = 0; x < 9; x++) {
                    if (board[y][x] == 0) {
                        board[y][x] = checkNumber(board, x, y);
                        if(board[y][x] != 0) zerocount--;
                    }
                }
            }
        }

        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                System.out.print(board[y][x] + " ");
            }
            System.out.println();
        }

        br.close();
    }

    public static int checkNumber(int[][] board, int x, int y) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < 10; i++) set.add(i);

        int groupX = (x / 3) * 3;
        int groupY = (y / 3) * 3;

        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 3; i++) {
                int value = board[groupY + j][groupX + i];
                if (value != 0 && set.contains(value)) {
                    set.remove(value);
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            int valueX = board[y][i];
            int valueY = board[i][x];
            if (valueX != 0 && set.contains(valueX)) set.remove(valueX);
            if (valueY != 0 && set.contains(valueY)) set.remove(valueY);
        }

        if (set.size() == 1) {
            for (int i : set)
                return i;
        }

        return 0;
    }
}
