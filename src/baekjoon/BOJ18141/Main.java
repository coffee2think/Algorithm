package src.baekjoon.BOJ18141;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// link: https://www.acmicpc.net/problem/18141
// date: 2025-10-15
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];

        // given
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // when
        boolean isAlways = true;

        loop:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;
                    if ((A[i] - A[j]) % A[k] != 0) {
                        isAlways = false;
                        break loop;
                    }
                }
            }
        }

        // then
        System.out.println(isAlways ? "yes" : "no");
        br.close();
    }
}
