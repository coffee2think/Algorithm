package baekjoon.BOJ6549;

import java.io.*;
import java.util.*;

/**
 * date: 2024-05-13
 * retry : 2025-07-23
 * source: https://www.acmicpc.net/problem/6549
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());

            // Given
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break; // 0이 입력될 경우 종료

            int[] heights = new int[n];
            for (int i = 0; i < n; i++) {
                heights[i] = Integer.parseInt(st.nextToken());
            }

            // Solution
            // 1. 순서대로 각 막대를 높이로 가지는 직사각형의 넓이를 구한다.
            // 2. 높이는 고정했으므로 왼쪽 경계와 오른쪽 경계를 찾아 너비를 계산한다.
            // 3. 넓이를 계산한 후 maxArea와 비교한다.

            int maxArea = 0;

            for (int i = 0; i < n; i++) {
                int width = 0;
                int area = 0;
                int left, right;

                left = right = i;
                while (left > 0 && heights[left - 1] >= heights[i]) {
                    left--;
                }
                while (right < n - 1 && heights[right + 1] >= heights[i]) {
                    right++;
                }

                width = right - left + 1;
                area = heights[i] * width;

                if (area > maxArea) {
                    maxArea = area;
                }
            }

            sb.append(maxArea).append("\n");
        }

        // Result
        System.out.println(sb.toString());
        br.close();
    }
}
