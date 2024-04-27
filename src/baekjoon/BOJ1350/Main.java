package src.baekjoon.BOJ1350;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * date: 2024-04-27
 * source: https://www.acmicpc.net/problem/1350
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int clusterSize = Integer.parseInt(br.readLine());
        long clusterCount = 0;

        for (int i = 0; i < N; i++) {
            clusterCount += (Integer.parseInt(st.nextToken()) + clusterSize - 1) / clusterSize; // 올림 계산
        }

        System.out.println(clusterCount * clusterSize);
        br.close();
    }
}
