package src.baekjoon.BOJ2012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * date: 2024-05-05
 * source: https://www.acmicpc.net/problem/2012
 */

// 카운팅 배열을 이용한 방법
public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] counting = new int[500_001];
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            counting[Integer.parseInt(br.readLine())]++;
        }

        int currentRank = 1;
        long gap = 0;
        for (int i = 1; i <= 500_000; i++) {
            while(counting[i] > 0) {
                gap += Math.abs(i - currentRank);
                counting[i]--;
                currentRank++;
            }
        }

        System.out.println(gap);
        br.close();
    }
}
