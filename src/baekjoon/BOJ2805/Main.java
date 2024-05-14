package src.baekjoon.BOJ2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * date: 2024-05-14
 * source: https://www.acmicpc.net/problem/2805
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // given
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int left = 0;
        int right = 0;

        int[] heights = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < heights.length; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, heights[i]);
        }

        // 이분탐색 수행
        int max = 0;
        while(left <= right) {
            int mid = (left + right) / 2;
            long sum = 0;

            for (int height : heights) {
                sum += Math.max(0, height - mid);
            }

            if (sum >= M) {
                max = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // then
        System.out.println(max);
        br.close();
    }
}
