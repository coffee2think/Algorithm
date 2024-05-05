package src.baekjoon.BOJ2012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * date: 2024-05-05
 * source: https://www.acmicpc.net/problem/2012
 */

// 배열 정렬을 이용한 방법
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] expectedRank = new int[N];
        for (int i = 0; i < expectedRank.length; i++) {
            expectedRank[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(expectedRank);

        long gap = 0;
        for (int i = 0; i < expectedRank.length; i++) {
            gap += Math.abs(expectedRank[i] - (i + 1));
        }

        System.out.println(gap);
        br.close();
    }
}
