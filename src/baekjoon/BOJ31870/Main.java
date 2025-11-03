package src.baekjoon.BOJ31870;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// link: https://www.acmicpc.net/problem/31870
// date: 2025-10-28
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // given
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // when
        int upCount = 0;
        int downCount = 0;


        // then

        br.close();
    }
}
