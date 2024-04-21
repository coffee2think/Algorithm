package src.baekjoon.BOJ2565;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] pos = new int[501];
        int[] dp = new int[501];

        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pos[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < pos.length; i++) {
            if(pos[i] == 0) continue;
            dp[i] = 1;

            for(int j = 0; j < i; j++) {
                if(pos[j] != 0 && pos[j] < pos[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = -1;
        for(int i = 0; i < dp.length; i++) {
            if(dp[i] > max) max = dp[i];
        }

        System.out.println(N - max);
        br.close();
    }
}
