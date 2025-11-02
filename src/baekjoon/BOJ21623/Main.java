package src.baekjoon.BOJ21623;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// link: https://www.acmicpc.net/problem/21623
// date: 2025-11-02
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // given
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] generator = new int[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            generator[i] = Integer.parseInt(st.nextToken());
        }

        // when
        int round = 0;
        int currentScore = n;
        for (int i = 0; i < k; i++) {
            if (currentScore == 0) {
                currentScore = n;
            }

            if (generator[i] > currentScore) {
                continue;
            }

            if (generator[i] == currentScore) {
                round++;
            }

            currentScore -= generator[i];
        }

        // then
        System.out.println(round + "\n" + currentScore);
        br.close();
    }
}
