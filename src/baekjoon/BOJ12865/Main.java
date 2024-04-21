package src.baekjoon.BOJ12865;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 물건 개수
        int K = Integer.parseInt(st.nextToken()); // 배낭의 최대 무게

        int[] w = new int[N + 1]; // 물건들의 무게(Weight)
        int[] v = new int[N + 1]; // 물건들의 가치(Value)
        int[] dp = new int[K + 1]; // 메모이제이션할 dp 배열

        // 물건들의 정보 입력
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int  j = K; j >= w[i]; j--) { // i번째 물건을 배낭에 담을 수 있는 동안만
                dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]); // i번째 물건을 넣었을 때와 넣지 않았을 때 중 큰 값을 기록
                System.out.println("i : " + i + ", j : " + j + ", dp[] : " + Arrays.toString(dp));
            }
        }

        System.out.println("배낭에 담을 수 있는 최댓값 : " + dp[K]);
        br.close();
    }
}
