package src.baekjoon.BOJ2747;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// source: https://www.acmicpc.net/problem/2747

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // given
        int n = Integer.parseInt(br.readLine());

        // solution
        int[] F = new int[n + 1];
        F[0] = 0;
        F[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            F[i] = F[i - 1] + F[i - 2];
        }

        // output
        System.out.println(F[n]);
        br.close();
    }
}
