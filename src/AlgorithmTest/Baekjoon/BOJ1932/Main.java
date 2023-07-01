package AlgorithmTest.Baekjoon.BOJ1932;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 데이터 입력
        int N = Integer.parseInt(br.readLine());
        int[][] triangle = new int[N][];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            triangle[i] = new int[i + 1];
            for (int j = 0; j < triangle[i].length; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // DP
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j > 0 && j < i) { // 중간에 위치한 경우
                    triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
                } else if (j == 0) { // 왼쪽 끝인 경우
                    triangle[i][j] += triangle[i - 1][j];
                } else { // 오른쪽 끝인 경우
                    triangle[i][j] += triangle[i - 1][j - 1];
                }
            }
        }

        // 마지막 결과 중 최댓값 선택
        int max = triangle[N - 1][0];
        for (int i = 1; i < triangle[N - 1].length; i++) {
            if (triangle[N - 1][i] > max) max = triangle[N - 1][i];
        }
        System.out.println(max);
        br.close();
    }
}
