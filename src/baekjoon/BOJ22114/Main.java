package src.baekjoon.BOJ22114;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// link: https://www.acmicpc.net/problem/22114
// date: 2025-10-22
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // given
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] distances = new int[N - 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < distances.length; i++) {
            distances[i] = Integer.parseInt(st.nextToken());
        }

        // when
        int left =  0;
        int right = 1;
        int jumpCount = 0;
        int maxRange = 0;
        while (right < N) {
            if (distances[right - 1] > K) {
                jumpCount++;
            }

            while (jumpCount > 1) {
                left++;
                if (distances[left - 1] > K) {
                    jumpCount--;
                }
            }

            maxRange = Math.max(right - left + 1, maxRange);
            right++;
        }

        // then
        System.out.println(maxRange);
        br.close();
    }
}
