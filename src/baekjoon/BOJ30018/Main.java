package src.baekjoon.BOJ30018;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// link: https://www.acmicpc.net/problem/30018
// date: 2025-10-15
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1, st2;

        int N = Integer.parseInt(br.readLine());
        int[] init = new int[N];
        int[] last = new int[N];
        int count = 0;

        // given
        st1 = new StringTokenizer(br.readLine());
        st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            init[i] = Integer.parseInt(st1.nextToken());
            last[i] = Integer.parseInt(st2.nextToken());
        }

        // when
        for (int i = 0; i < N; i++) {
            int diff = last[i] - init[i];
            if (diff > 0) {
                count += diff;
            }
        }

        // then
        System.out.println(count);
        br.close();
    }
}
