package src.baekjoon.BOJ1074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * date: 2024-05-28
 * source: https://www.acmicpc.net/problem/1074
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // given
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        // solution
        int result = divide((int) Math.pow(2, N - 1), r, c);

        // print result
        System.out.println(result);
        br.close();
    }

    public static int divide(int div, int r, int c) {
        int order = c / div + r / div * 2; // 구역 순서
        order *= div * div; // 4^(N-1)을 곱함

        if (div > 1) {
            order += divide(div / 2, r % div, c % div); // 더 작은 부분에서의 순서를 더함
        }

        return order;
    }
}
