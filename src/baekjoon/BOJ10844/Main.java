package src.baekjoon.BOJ10844;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] stairNum = new int[N][10];
        for (int i = 1; i < 10; i++) {
            stairNum[0][i] = 1;
        }

        for (int i = 1; i < N; i++) {
            stairNum[i][0] = stairNum[i - 1][1];
            stairNum[i][9] = stairNum[i - 1][8];
            for (int n = 1; n < 9; n++) {
                stairNum[i][n] = (stairNum[i - 1][n - 1] + stairNum[i - 1][n + 1]) % 1000000000;
            }
        }

        int result = 0;
        for (int i = 0; i < 10; i++) {
            result = (result + stairNum[N - 1][i]) % 1000000000;
        }
        System.out.println(result);

        br.close();
    }
}
