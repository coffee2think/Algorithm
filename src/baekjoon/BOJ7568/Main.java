package src.baekjoon.BOJ7568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * date: 2024-11-06
 * source: https://www.acmicpc.net/problem/7568
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
//        StringTokenizer st; // StringTokenizer는 레거시 클래스로 최신 자바에서는 사용이 권장되지 않음. String.split() 메소드 사용 권장

        // given
        int N = Integer.parseInt(br.readLine());
        int[][] bodyProfiles = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] tokens = br.readLine().split(" ");
            bodyProfiles[i][0] = Integer.parseInt(tokens[0]);
            bodyProfiles[i][1] = Integer.parseInt(tokens[1]);
        }

        // solution
        int[] rank = new int[N];
        Arrays.fill(rank, 1);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (bodyProfiles[i][0] < bodyProfiles[j][0] && bodyProfiles[i][1] < bodyProfiles[j][1]) {
                    rank[i]++;
                }
            }
        }

        // print result
        for (int i = 0; i < N; i++) {
            sb.append(rank[i]).append(" ");
        }
        System.out.println(sb);
        br.close();
    }
}
