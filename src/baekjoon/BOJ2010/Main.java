package src.baekjoon.BOJ2010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * date: 2024-05-05
 * source: https://www.acmicpc.net/problem/2010
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int sum = 1;

        for (int i = 0; i < N; i++) {
            sum += Integer.parseInt(br.readLine());
        }

        System.out.println(sum - N);
        br.close();
    }
}
