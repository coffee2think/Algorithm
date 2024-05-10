package src.baekjoon.BOJ1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * date: 2024-05-10
 * source: https://www.acmicpc.net/problem/1629
 */

public class Main {
    private static int[] pow;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // given
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        // when
        pow = new int[(int)(Math.log(B) / Math.log(2)) + 1];
        pow[0] = A % C;

        for (int i = 1; i < pow.length; i++) {
            pow[i] = (int)(((long)pow[i - 1] * pow[i - 1]) % C);
        }

        int answer = 1;
        for (int i = 0; i < pow.length; i++) {
            if (B % 2 == 1) {
                answer = (int)(((long)answer * pow[i]) % C);
            }

            B /= 2;
        }

        // output
        System.out.println(answer);
        br.close();
    }
}
