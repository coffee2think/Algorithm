package src.baekjoon.BOJ1439;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * date: 2024-05-05
 * source: https://www.acmicpc.net/problem/1439
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        int changeCount = 0;

        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i - 1) != S.charAt(i)) {
                changeCount++;
            }
        }

        System.out.println((changeCount + 1) / 2);
        br.close();
    }
}
