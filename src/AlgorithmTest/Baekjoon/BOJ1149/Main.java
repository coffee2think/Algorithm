package AlgorithmTest.Baekjoon.BOJ1149;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] RGB = new int[N][3];
        int[][] minCost = new int[N][3]; // 최소값을 저장할 배열

        // RGB 데이터 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                RGB[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 최소값 찾기
        minCost[0][0] = RGB[0][0];
        minCost[0][1] = RGB[0][1];
        minCost[0][2] = RGB[0][2];
        for (int i = 1; i < N; i++) {
            minCost[i][0] = Math.min(minCost[i - 1][1], minCost[i - 1][2]) + RGB[i][0];
            minCost[i][1] = Math.min(minCost[i - 1][0], minCost[i - 1][2]) + RGB[i][1];
            minCost[i][2] = Math.min(minCost[i - 1][0], minCost[i - 1][1]) + RGB[i][2];
        }

        // 결과 출력
        int minResult = Math.min(Math.min(minCost[N - 1][0], minCost[N - 1][1]), minCost[N - 1][2]);
        System.out.println(minResult);
        br.close();
    }
}
